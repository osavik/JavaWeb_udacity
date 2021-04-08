import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class SaltExample {

    public static void main(String[] args)throws NoSuchAlgorithmException, NoSuchProviderException {
        // A static String for the example
        String passwordToHash = "myPassword";

        // Create a salt
        byte[] salt = createSalt();

        // Create a hash
        String securePassword = get_SecurePassword(passwordToHash, salt);
        System.out.println(securePassword);

        String securePasswordMD5_withSalt = get_SecurePassword_MD5_WithSALT(passwordToHash, salt);
        System.out.println(securePasswordMD5_withSalt);

        String securePasswordMD5_withoutSalt = get_SecurePassword_MD5_WithoutSALT(passwordToHash);
        System.out.println(securePasswordMD5_withoutSalt);
    }

    // Method to generate a Salt
    private static byte[] createSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    // Method to generate the hash.
//It takes a password and the Salt as input arguments
    private static String get_SecurePassword(String passwordToHash, byte[] salt){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    private static String get_SecurePassword_MD5_WithSALT(String passwordToHash, byte[] salt){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    private static String get_SecurePassword_MD5_WithoutSALT(String passwordToHash){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}

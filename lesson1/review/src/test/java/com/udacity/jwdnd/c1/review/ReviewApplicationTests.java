package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.pages.ChatPage;
import com.udacity.jwdnd.c1.review.pages.LoginPage;
import com.udacity.jwdnd.c1.review.pages.SignupPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ReviewApplicationTests {
	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private LoginPage loginPage;
	private SignupPage signupPage;
	private ChatPage chatPage;

	public String baseUrl;

	@BeforeAll
	public static void beforeAll(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll() {
		driver.quit();
		driver = null;
	}

	@BeforeEach
	public void beforeEach(){
		baseUrl = "http://localhost:" + port;
	}

	@Test
	public void testSignupLoginSubmitMessage(){
		String firstName = "Jon";
		String lastName = "Dou";
		String username = "foo";
		String password = "veryweakpassword";

		driver.get(baseUrl + "/signup");
		signupPage = new SignupPage(driver);
		signupPage.signupProcess(firstName, lastName, username, password);

		driver.get(baseUrl + "/login");
		loginPage = new LoginPage(driver);
		loginPage.loginProcess(username, password);

		String message = "hello world";
		driver.get(baseUrl + "/chat");
		chatPage = new ChatPage(driver);
		chatPage.submitMessageProcess(message, "Say");

		assertEquals(message, chatPage.getChatMessageText());
		assertEquals(username, chatPage.getChatMessageUsername());
	}

	@Test
	public void testMultipleUserSupport() throws InterruptedException {

		// signup 2 users
		driver.get(baseUrl + "/signup");
		signupPage = new SignupPage(driver);
		signupPage.signupProcess("firstName1", "lastName1", "username1", "password1");

		//driver.get(baseUrl + "/signup");
		signupPage = new SignupPage(driver);
		signupPage.signupProcess("firstName2", "lastName2", "username2", "password2");

		// login as username1
		driver.get(baseUrl + "/login");
		loginPage = new LoginPage(driver);
		loginPage.loginProcess("username1", "password1");

		// write message1
		String message = "hello world";
		driver.get(baseUrl + "/chat");
		chatPage = new ChatPage(driver);
		chatPage.submitMessageProcess(message, "Say");

		// logout
		chatPage.logoutButton();

		// login as username2
		driver.get(baseUrl + "/login");
		loginPage = new LoginPage(driver);
		loginPage.loginProcess("username2", "password2");

		driver.get(baseUrl + "/chat");
		chatPage = new ChatPage(driver);
		assertEquals(message, chatPage.getChatMessageText());
		assertEquals("username1", chatPage.getChatMessageUsername());

	}

}

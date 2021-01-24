package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/animal");


        WebElement inputAnimalName = driver.findElement(By.id("animalText"));
        WebElement inputAdjective = driver.findElement(By.id("adjective"));
        inputAnimalName.sendKeys("DOG");
        inputAdjective.sendKeys("HAPPY");

        for(int i=0; i<5; ++i){

            inputAdjective = driver.findElement(By.id("adjective"));
            inputAdjective.submit();
            List<WebElement> trainingResults = driver.findElements(By.className("trainingMessage"));
            System.out.println("trainingResults.size() = " + trainingResults.size());

            Thread.sleep(2000);
        }

        WebElement conclusionMessage = driver.findElement(By.className("conclusionMessage"));
        System.out.println(conclusionMessage.getText());
        Thread.sleep(5000);
        driver.quit();
    }
}

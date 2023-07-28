package registration.test;

import base.Base;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class RegistrationUsingFirefoxTest extends Base {

    @Test
    public void register() {

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Felix");
        driver.findElement(By.id("LastName")).sendKeys("Monday");
        String randomEmail = RandomStringUtils.randomAlphanumeric(5) + "@gmail.com";
        driver.findElement(By.id("Email")).sendKeys(randomEmail);
        driver.findElement(By.id("Password")).sendKeys("abc@123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("abc@123");

        driver.findElement(By.id("register-button")).click();

        String message = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")).getText();

        if(message.contains("registration completed")) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed");
        }

    }

    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver = initializeBrowser("firefox");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

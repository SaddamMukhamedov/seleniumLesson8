package net.absoft;

import static org.testng.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestUserIsLockedOut {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/Users/saddammukhamedov/Documents/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void LoginUserWithLockedOutUser() {

        driver.get("https://www.saucedemo.com/");
        assertEquals(driver.getTitle(), "Swag Labs", "Unexpected Swag labs page title");
        driver.findElement(By.xpath("//input[@data-test='username']"))
                .sendKeys("locked_out_user");
        driver.findElement(By.xpath("//input[@data-test='password']"))
                .sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@data-test='login-button']")).click();
        assertEquals(driver.findElement(By.cssSelector("h3[data-test='error']")).getText(), "Epic sadface: Sorry, this user has been locked out.", "Unexpected error");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

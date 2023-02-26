package net.absoft;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.*;



public class LoginWithoutPasswordTest {

    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/Users/saddammukhamedov/Documents/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Login-Portal/index.html?");
    }

    @Test
    public void testName() {
        driver.findElement(By.cssSelector("#text[placeholder='Username']")).sendKeys("usernameLogin");
        driver.findElement(By.id("login-button")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "validation failed", "Alert message is not 'Validation failed'");
        alert.accept();
        assertTrue(driver.findElement(By.id("login-button")).isDisplayed(), "User is logged in");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}

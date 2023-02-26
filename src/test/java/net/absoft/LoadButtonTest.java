package net.absoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.*;


public class LoadButtonTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/Users/saddammukhamedov/Documents/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Ajax-Loader/index.html");
    }
    
        @Test
    public void AjaxLoaderTest() {
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
            driver.findElement(By.xpath("//p[text()='CLICK ME!']")).click();
            assertTrue(driver.findElement(By.cssSelector("div[style='display: block;'][class='modal fade in']")).isDisplayed(), "Modal window isn't displayed");
           WebElement closeButton = driver.findElement(By.cssSelector("button[data-dismiss='modal'][class*='btn-def']"));
            closeButton.click();
            assertFalse(driver.findElement(By.cssSelector("div[style='display: none;'][class='modal fade']")).isDisplayed(), "Modal window is still opened");

        }

    
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

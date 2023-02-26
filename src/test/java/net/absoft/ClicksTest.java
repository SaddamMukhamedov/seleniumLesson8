package net.absoft;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class ClicksTest {

    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/Users/saddammukhamedov/Documents/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Click-Buttons/index.html");
    }

    @Test
    public void testName() {
        WebElement WebElementButton = driver.findElement(By.xpath("//span[@data-target='#myModalClick']"));
        WebElementButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div[3]/button")).click();


        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement JSButton = driver.findElement(By.cssSelector("span[data-target='#myModalJSClick']"));
        jsExecutor.executeScript("arguments[0].click();", JSButton);
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("#myModalClick div.modal-footer > button")));

        Actions actions = new Actions(driver);
        WebElement thirdButton = driver.findElement(By.xpath("//span[@data-target='#myModalMoveClick']"));
        actions.moveToElement(thirdButton).click().perform();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

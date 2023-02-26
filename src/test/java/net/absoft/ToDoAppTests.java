package net.absoft;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

import static org.testng.Assert.*;


public class ToDoAppTests {

    WebDriver driver;
    private final String TextToAdd = "TestAddToList";

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/Users/saddammukhamedov/Documents/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
    }


    @Test
    public void ToDoAdd() {

        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        WebElement input = driver.findElement(By.xpath("//input"));
        input.sendKeys(TextToAdd + Keys.RETURN);
        assertTrue(driver.findElement(By.xpath("//ul//li[contains(text(), " + TextToAdd + ")]")).isDisplayed());


    }

    @Test
    public void toDeleteListItem() {
        Actions actions = new Actions(driver);
         driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

        actions.moveToElement(driver.findElement(By.xpath("//ul//li[contains(text(), " + TextToAdd + ")]"))).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//li[contains(text(), '" + TextToAdd + "')]//i"))
        );

//        try {
//            assertFalse(driver.findElement(By.xpath("//li[contains(text(), '" + TextToAdd + "')]//i")).isDisplayed(), "The row is displayed.");
//        }
//        catch (NoSuchElementException e) {
//            // do nothing if element not found
        }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}

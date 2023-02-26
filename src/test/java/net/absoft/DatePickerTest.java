package net.absoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DatePickerTest {

    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/Users/saddammukhamedov/Documents/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Datepicker/index.html");
    }

    @Test
    public void datePickerTest() {
        WebElement datePicker = driver.findElement(By.xpath("//input[@class='form-control']"));
        datePicker.click();
        driver.findElement(By.xpath("//th[@class='datepicker-switch' and text()='February 2023']")).click();
        WebElement prevButton = driver.findElement(By.xpath("//div[@class='datepicker-months']//th[@class='prev' and text()='«']"));
        WebElement yearButton = driver.findElement(By.xpath("//th[@class='datepicker-switch' and text()='2023']"));
        while (!yearButton.getText().equals("1991")) {
            prevButton.click();
        }
        //th[@class='datepicker-switch' and text()='2023']
        driver.findElement(By.xpath("//span[@class='month' and text() = 'Aug']")).click();
        driver.findElement(By.xpath("//td[@class='day' and text()='24']")).click();
        assertEquals(datePicker.getAttribute("value"), "08-24-1991", "Date is wrong");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

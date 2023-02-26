package net.absoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DropdownCheckboxesRadioButtonsTest {
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/Users/saddammukhamedov/Documents/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

    }

    @Test
    public void dropdownMenus() {

        WebElement dropdownElement1 = driver.findElement(By.id("dropdowm-menu-1"));
        Select selectFirstDropdown = new Select(dropdownElement1);

        if (!selectFirstDropdown.getFirstSelectedOption().getText().equals("JAVA"))
            selectFirstDropdown.selectByVisibleText("JAVA");
        assertEquals(selectFirstDropdown.getFirstSelectedOption().getText(), "JAVA", "The selected element is not JAVA");



        WebElement dropdownElement2 = driver.findElement(By.id("dropdowm-menu-2"));
        Select selectSecondDropdown = new Select(dropdownElement2);

        if (!selectSecondDropdown.getFirstSelectedOption().getText().equals("TestNG"))
            selectSecondDropdown.selectByVisibleText("TestNG");
        assertEquals(selectSecondDropdown.getFirstSelectedOption().getText(), "TestNG", "The selected value is not TestNG");



        WebElement dropdownElement3 = driver.findElement(By.id("dropdowm-menu-3"));
        Select selectThirdDropdown = new Select(dropdownElement3);

        if (!selectThirdDropdown.getFirstSelectedOption().getText().equals("HTML"))
            selectThirdDropdown.selectByVisibleText("HTML");
        assertEquals(selectThirdDropdown.getFirstSelectedOption().getText(), "HTML", "The selected value is not HTML");
    }

    @Test
    public void CheckboxesTest() {
       // driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");


            WebElement checkbox1 = driver.findElement(By.cssSelector("input[value='option-1']"));
            WebElement checkbox2 = driver.findElement(By.cssSelector("input[value='option-2']"));
            WebElement checkbox3 = driver.findElement(By.cssSelector("input[value='option-3']"));
            WebElement checkbox4 = driver.findElement(By.cssSelector("input[value='option-4']"));

            if (checkbox1.isSelected()); else checkbox1.click();
            if (checkbox2.isSelected())  checkbox2.click();
            if (checkbox3.isSelected())  checkbox3.click();
            if (checkbox4.isSelected()); else checkbox4.click();
            assertTrue(checkbox1.isSelected(), "Checkbox wasn't selected");
            assertFalse(checkbox2.isSelected(), "Checkbox is selected");
            assertFalse(checkbox3.isSelected(), "Checkbox is selected");
            assertTrue(checkbox4.isSelected(), "Checkbox wasn't selected");



    }

    @Test
    public void RadioButtonsTest() {
        WebElement radioButton = driver.findElement(By.cssSelector("input[value='orange']"));
        radioButton.click();
        assertTrue(radioButton.isSelected(), "Radio button isn't selected");
    }

    @Test
    public void SelectedAndDisabledTest() {
        assertTrue(driver.findElement(By.cssSelector("input[value='pumpkin']")).isSelected(), "The pumpkin isn't selected by default");
        Select option = new Select(driver.findElement(By.id("fruit-selects")));
        assertTrue(option.getFirstSelectedOption().getText().equals("Grape"), "Grape is not selected" );
        assertFalse(driver.findElement(By.cssSelector("input[value='cabbage']")).isEnabled(), "The element is enabled");
        for (int i = 0; i<4; i++)
        {
            if (option.getOptions().get(i).getText().equals("Orange"))
                assertFalse(option.getOptions().get(i).isEnabled(), "The Orange element is enabled.");
        }

    }



    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}

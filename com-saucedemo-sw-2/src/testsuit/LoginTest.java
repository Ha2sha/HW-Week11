package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find username field & assign values
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");

        //find password field & assign values
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");

        //find Login Button & click on it
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        String expectedText = "PRODUCTS";

        //find actualTextElement &get Text
        WebElement actualTextElement = driver.findElement(By.tagName("span"));
        String actualText = actualTextElement.getText();

        //Validating expected & actual texts
        Assert.assertEquals("Unsuccessful Login", expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //find username field & assign values
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");

        //find password field & assign values
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");

        //find Login Button & click on it
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        int expectedItems = 6;

        //find 6 items on homepage
        List<WebElement> inventory = driver.findElements(By.className("inventory_item"));
        int actualItems = inventory.size();

        //validating expected & actual items
        Assert.assertEquals("6 items Not displayed", expectedItems, actualItems);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

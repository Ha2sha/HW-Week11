package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find username field & assign values
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("tomsmith");

        //find password field & assign values
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        //find Login Button & click on it
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        String expectedText = "Secure Area";

        //find actualTextElement & get Text
        WebElement actualTextElement = driver.findElement(By.tagName("h2"));
        String actualText = actualTextElement.getText();

        //Validating expected & actual texts
        Assert.assertEquals("Unsuccessful Login", expectedText, actualText);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //find username field & assign values
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("tomsmith1");

        //find password field & assign values
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        //find Login Button & click on it
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        //this is the requirement
        String expectedResult = "Your username is invalid!";

        //for test to pass
        //String expectedResult = "Your username is invalid!\n"+"×";

        //find actualTextElement & get Text
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualResult = actualTextElement.getText();

        //Validating expected & actual texts
        Assert.assertEquals("Invalid Username", expectedResult, actualResult);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //find username field & assign values
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("tomsmith");

        //find password field & assign values
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword");

        //find Login Button & click on it
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        //this is the requirement
        String expectedResult = "Your password is invalid!";

        //for test to pass
        //String expectedResult = "Your password is invalid!\n"+"×";

        //find actualTextElement & get Text
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualResult=actualTextElement.getText();

        //Validating expected & actual texts
        Assert.assertEquals("Invalid Password", expectedResult, actualResult);
    }

    @After
    public void teraDown() {
        closeBrowser();
    }

}

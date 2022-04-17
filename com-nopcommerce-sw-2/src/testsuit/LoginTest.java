package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //find login link & click on the login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        //This is from the requirement doc
        String expectedMessage="Welcome, Please Sign In!";

        //find the welcome text element & get the text from element
        WebElement actualMessageElement=driver.findElement(By.tagName("h1"));
        String actualMessage=actualMessageElement.getText();

        //Validated actual & expected messages
        Assert.assertEquals("Login Page not found",expectedMessage,actualMessage);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find login link & click on the login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        //find email field & assign value to it
        WebElement emailField=driver.findElement(By.id("Email"));
        emailField.sendKeys("abc@gmail.com");

        //find password field & assign value to it
        WebElement passwordField=driver.findElement(By.name("Password"));
        passwordField.sendKeys("harsha22");

        //find login Button element & click on it
        WebElement loginButton=driver.findElement(By.cssSelector("button[class='button-1 login-button']"));
        loginButton.click();

        String expectedLogoutText="Log out";

        //find logout text element & get text
        WebElement logoutTextElement=driver.findElement(By.linkText("Log out"));
        String actualLogoutText=logoutTextElement.getText();

        //validating expected & actual texts
        Assert.assertEquals("Not Found", expectedLogoutText,actualLogoutText);

    }

    @Test
    public void userShouldNotLoginSuccessfullyWithInValidCredentials(){
        //find login link & click on the login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        //find emailField and pass incorrect email address
        WebElement emailField=driver.findElement(By.id("Email"));
        emailField.sendKeys("hello@gmail.com");

        //find passwordField and pass incorrect password
        WebElement passwordField=driver.findElement(By.id("Password"));
        passwordField.sendKeys("hello123");

        //find Login Button and click it
        WebElement loginButton=driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();

        //this is form teh requirement
        String expectedErrorMsg="Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        //find error message element & get text
        WebElement errorMessageElement=driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualErrorMsg=errorMessageElement.getText();

        //Validated actual & expected error messages
        Assert.assertEquals("Error not displayed",expectedErrorMsg, actualErrorMsg);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}

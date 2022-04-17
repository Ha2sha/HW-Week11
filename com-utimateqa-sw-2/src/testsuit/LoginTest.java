package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //find sign-in link & click on it
        WebElement signIn=driver.findElement(By.linkText("Sign In"));
        signIn.click();

        String expectedText="Welcome Back!";

        //find actual text element & get text
        WebElement actualTextElement=driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String actualText=actualTextElement.getText();

        //Validating expected & actual texts
        Assert.assertEquals("Sign In Link not working",expectedText,actualText);
    }

    @Test
    public void verifyTheErrorMessage(){
        //find sign-in link & click on it
        WebElement signIn=driver.findElement(By.linkText("Sign In"));
        signIn.click();

        //find email field & send values
        WebElement emailField= driver.findElement(By.id("user[email]"));
        emailField.sendKeys("abc@gmail.com");

        //find password field & send values
        WebElement passwordField= driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("abc123");

        //find signIn button & click on it
        WebElement signInButton=driver.findElement(By.xpath("//input[@type='submit']"));
        signInButton.click();

        String expectedMsg="Invalid email or password.";
        //find actual msg element & get text
        WebElement actualElement=driver.findElement(By.xpath("//li[@role='alert']"));
        String actualMsg=actualElement.getText();

        //Validating Actual & Expected texts
        Assert.assertEquals("Enter Valid Credentials",expectedMsg,actualMsg);
    }

    @After
    public void teraDown() {
    closeBrowser();
    }

}

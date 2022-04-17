package TestSuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl="https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp(){
    openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){

        //find forgot password link element & click on it
        WebElement forgotPassword=driver.findElement(By.linkText("Forgot your password?"));
        forgotPassword.click();

        String expectedText="Forgot Your Password?";

        //find forgotPassword text & get text
        WebElement actualTextElement=driver.findElement(By.tagName("h1"));
        String actualText=actualTextElement.getText();

        //validating expected & actual texts
        Assert.assertEquals("Link is Broken",expectedText,actualText);

    }
    @After
    public void tearDown(){
      closeBrowser();
    }
}

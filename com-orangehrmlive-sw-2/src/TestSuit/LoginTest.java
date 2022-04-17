package TestSuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl="https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find username field & assign values to it
        WebElement userName=driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");

        //find password field & assign values to it
        WebElement password=driver.findElement(By.id("txtPassword"));
        password.sendKeys("admin123");

        //find Login Button & click on it
        WebElement loginButton=driver.findElement(By.name("Submit"));
        loginButton.click();

        String expectedMsg="Welcome Paul";

        //find welcome txt element & get text
        WebElement actualMsgElement=driver.findElement(By.id("welcome"));
        String actualMasg=actualMsgElement.getText();

        //validating expected & actual texts
        Assert.assertEquals("Login Unsuccessful",expectedMsg,actualMasg);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}

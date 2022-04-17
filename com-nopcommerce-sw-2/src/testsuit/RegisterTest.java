package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        //find Register element & click on it
        WebElement registerPage = driver.findElement(By.className("ico-register"));
        registerPage.click();

        String expectedText = "Register";

        //find register page text element & get text
        WebElement registerPageTextElement = driver.findElement(By.tagName("h1"));
        String actualText = registerPageTextElement.getText();

        //validating expected & actual texts
        Assert.assertEquals("Page Not Found", expectedText, actualText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //find Register element & click on it
        WebElement registerPage = driver.findElement(By.className("ico-register"));
        registerPage.click();
        //find gender element & click on it
        WebElement gender=driver.findElement(By.cssSelector("span.female"));
        gender.click();
        //find firstname text box & assign values
        WebElement firstName=driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Harsha");
        //find lastName text box & assign values
        WebElement lastName=driver.findElement(By.id("LastName"));
        lastName.sendKeys("Patel");
        //find DOB day element & assign values
        WebElement day=driver.findElement(By.name("DateOfBirthDay"));
        day.sendKeys("22");
        //find DOB month element & assign values
        WebElement month=driver.findElement(By.name("DateOfBirthMonth"));
        month.sendKeys("January");
        //find DOB Year element & assign values
        WebElement year=driver.findElement(By.name("DateOfBirthYear"));
        day.sendKeys("1982");
        //find email field & assign value to it
        WebElement emailField=driver.findElement(By.xpath("//input[@type='email']"));
        emailField.sendKeys("abc@gmail.com");
        //find password field & assign value to it
        WebElement passwordField=driver.findElement(By.xpath("//input[@id='Password']"));
        passwordField.sendKeys("harsha22");
        //find confirm password field & assign value to it
        WebElement confirmPasswordField=driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPasswordField.sendKeys("harsha22");
        //find Register button & click on it
        WebElement registerButton=driver.findElement(By.xpath("//button[@name='register-button']"));
        registerButton.click();

        String expectedResult="Your registration completed";

        //find register result element & get text
        WebElement registerResultElement=driver.findElement(By.cssSelector(".result"));
        String actualResult=registerResultElement.getText();

        //validating expected & actual result
        Assert.assertEquals("Registration not successful",expectedResult,actualResult);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}

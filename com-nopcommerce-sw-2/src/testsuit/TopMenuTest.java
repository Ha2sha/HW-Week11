package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {

        //find the Computer tab element & click on it
        WebElement computerTab = driver.findElement(By.linkText("Computers"));
        computerTab.click();

        String expectedTabText = "Computers";

        //find & get text from Computer tab element text
        WebElement computerTextElement = driver.findElement(By.tagName("h1"));
        String actualTabText = computerTextElement.getText();

        //validating actual & expected texts
        Assert.assertEquals("Page not Found", expectedTabText, actualTabText);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        //find the Electronics tab element & click on it
        WebElement electronicsTab = driver.findElement(By.linkText("Electronics"));
        electronicsTab.click();

        String expectedTabText = "Electronics";

        //find & get text from Electronics tab element text
        WebElement electronicsTextElement = driver.findElement(By.tagName("h1"));
        String actualTabText = electronicsTextElement.getText();

        //validating actual & expected texts
        Assert.assertEquals("Page not Found", expectedTabText, actualTabText);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        //find Apparel tab element & click on it
        WebElement apparelTab = driver.findElement(By.linkText("Apparel"));
        apparelTab.click();

        String expectedTabText = "Apparel";

        //find & get text from Apparel tab element text
        WebElement apparelTextElement = driver.findElement(By.linkText("Apparel"));
        String actualTabText = apparelTextElement.getText();

        //validating actual & expected texts
        Assert.assertEquals("Page Not Found", expectedTabText, actualTabText);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        //find Digital Downloads tab element & click on it
        WebElement digitalDownloadsTab = driver.findElement(By.linkText("Digital downloads"));
        digitalDownloadsTab.click();

        String expectedTabText = "Digital downloads";

        //find & get text from Digital downloads  tab element text
        WebElement digitalDownloadsTextElement = driver.findElement(By.linkText("Digital downloads"));
        String actualTabText = digitalDownloadsTextElement.getText();

        //validating actual & expected texts
        Assert.assertEquals("Page Not Found", expectedTabText, actualTabText);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        //find the Books tab element & click on it
        WebElement booksTab = driver.findElement(By.linkText("Books"));
        booksTab.click();

        String expectedTabText = "Books";

        //find & get text from Books tab element text
        WebElement booksTextElement = driver.findElement(By.tagName("h1"));
        String actualTabText = booksTextElement.getText();

        //validating actual & expected texts
        Assert.assertEquals("Page not Found", expectedTabText, actualTabText);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        //find the Jewelry tab element & click on it
        WebElement jewelryTab = driver.findElement(By.linkText("Jewelry"));
        jewelryTab.click();

        String expectedTabText = "Jewelry";

        //find Jewelry tab element text & get text
        WebElement jewelryTextElement = driver.findElement(By.tagName("h1"));
        String actualTabText = jewelryTextElement.getText();

        //validating actual & expected texts
        Assert.assertEquals("Page not Found", expectedTabText, actualTabText);
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        //find Giftcards tab element & click on it
        WebElement giftCardsTab=driver.findElement(By.linkText("Gift Cards"));
        giftCardsTab.click();

        String expectedTabText="Gift Cards";

        //find Giftcards text element & get text from it
        WebElement giftCardTextElement=driver.findElement(By.linkText("Gift Cards"));
        String actualTabText=giftCardTextElement.getText();

        //validation expected & actual results
        Assert.assertEquals("Page not Found",expectedTabText,actualTabText);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }

}

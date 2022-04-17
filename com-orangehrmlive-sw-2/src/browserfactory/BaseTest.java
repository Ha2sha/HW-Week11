package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl){
        //set property for chrome browser
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        //created object od ChromeDriver class
        driver=new ChromeDriver();

        //launch URl
        driver.get(baseUrl);

        //maximise the window
        driver.manage().window().maximize();

        //set implicit time for driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void closeBrowser(){
        driver.quit();
    }

}

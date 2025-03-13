package utilityPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

import java.time.Duration;

public class SeleniumUtils {
    public static WebDriver driver;
    protected String greatGrandParent = "//parent::*//parent::*//parent::*";
    public static void initialiseDriver(String browser){
        if(browser.equalsIgnoreCase("chrome")){
        driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(6));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }
    public static void launchUrl(){
        driver.get("https://www.saucedemo.com/v1/");
    }
    @AfterClass
    public static void teardown(){
        if (!(driver ==null)){
            driver.quit();
        }
    }

}

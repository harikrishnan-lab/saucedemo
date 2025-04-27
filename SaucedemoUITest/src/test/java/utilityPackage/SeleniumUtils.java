package utilityPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SeleniumUtils {
    public static WebDriver driver;
    protected String greatGrandParent = "//parent::*//parent::*//parent::*";

    public static void initialiseDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            // Set Chrome options
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(6));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    public static void launchUrl() {
        driver.get("https://www.saucedemo.com/v1/");
    }

    @AfterClass
    public static void teardown() {
        if (!(driver == null)) {
            driver.quit();
        }
    }

    public void waitForElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
    }

    public void enterText(By element, String text) {
        waitForElement(element);
        driver.findElement(element).sendKeys(text);
    }

    public void clickElement(By element) {
        waitForElement(element);
        driver.findElement(element).click();
    }

}

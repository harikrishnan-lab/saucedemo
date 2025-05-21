package utilityPackage;


import PageClass.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utilityPackage.selenium.ExtendReportListener;
import utilityPackage.ReportUtil.Log;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static java.nio.file.Paths.get;

@Listeners(ExtendReportListener.class)
public class BaseTest{
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    public static String reportPath;
    public static LoginPage loginPage;
    public static ProductPage productPage;
    public static FinishPage finishPage;
    public static CustomerDetailsPage customerDetailsPage;
    public static CartPage cartPage;
    public static WebDriver driver;
@BeforeClass
    public static void setup() {
        initialiseDriver("chrome");
        launchUrl();
        loginPage = new LoginPage();
        productPage = new ProductPage();
        finishPage = new FinishPage();
        customerDetailsPage = new CustomerDetailsPage();
        cartPage = new CartPage();
    }
    @AfterClass
    public static void teardown() {
        driver.quit();
    }
    public String takeScreenshot() {
        File screenshotDir = new File(System.getProperty("user.dir") + "/test-output/screenshots/");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }
        // Generate screenshot path
        String path = System.getProperty("user.dir") + "/test-output/screenshots/" + System.currentTimeMillis() + ".png";
        try {
            // Take screenshot of the entire page
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Save the screenshot to the specified path
            FileUtils.copyFile(screenshot, new File(path));
        } catch (IOException e) {
            System.out.println("Error while taking screenshot: " + e.getMessage());
        }
        return path;
    }
    public static void initialiseDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            // Set Chrome options
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
            Log.info("Chrome Browser Opened");
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new InternetExplorerDriver();
            Log.info("InternetExplorer Browser Opened");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(6));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }
    public static void launchUrl() {
        driver.get("https://www.saucedemo.com/v1/");
    }
}


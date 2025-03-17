package utilityPackage;


import PageClass.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;

import static java.nio.file.Paths.get;

@Listeners(ExtendReportListener.class)
public class BaseTest extends SeleniumUtils {
    public static LoginPage loginPage;
    public static ProductPage productPage;
    public static FinishPage finishPage;
    public static CustomerDetailsPage customerDetailsPage;
    public static CartPage cartPage;
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
}


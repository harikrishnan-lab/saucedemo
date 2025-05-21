package utilityPackage.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.ITestAnnotation;
import utilityPackage.ReportUtil.ExtendReportListener;
import utilityPackage.ReportUtil.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.Duration;

public class seleniumUtil {
    public static class SeleniumUtils extends ExtendReportListener {

        protected String greatGrandParent = "//parent::*//parent::*//parent::*";
        @AfterClass
        public static void teardown() {
            if (!(driver == null)) {
                driver.quit();
                Log.info("Browser Closed");
            }
        }

        public void waitForElement(By element) {
            Log.info("Webdriver is waiting for Element "+element.toString());
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
        }

        public void enterText(By element, String text) {
            waitForElement(element);
            driver.findElement(element).sendKeys(text);
            Log.info(element +" is entered with text "+text);
        }

        public void clickElement(By element) {
            waitForElement(element);
            driver.findElement(element).click();
        }

    }


}

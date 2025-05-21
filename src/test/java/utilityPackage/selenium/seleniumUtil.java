package utilityPackage.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import utilityPackage.ReportUtil.Log;

import java.time.Duration;

public class seleniumUtil extends ExtendReportListener {

    protected String greatGrandParent = "//parent::*//parent::*//parent::*";

    public void waitForElement(By element) {
        Log.info("Webdriver is waiting for Element " + element.toString());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
    }

    public void enterText(By element, String text) {
        waitForElement(element);
        driver.findElement(element).sendKeys(text);
        Log.info(element + " is entered with text " + text);
    }

    public void clickElement(By element) {
        waitForElement(element);
        driver.findElement(element).click();
    }

}




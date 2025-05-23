package utilityPackage.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class seleniumUtil extends ExtendReportListener {

    protected String greatGrandParent = "//parent::*//parent::*//parent::*";

    public void waitForElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
        reportStep(element.toString()+" is clickable","pass");
    }

    public void enterText(By element, String text) {
        waitForElement(element);
        driver.findElement(element).sendKeys(text);
        reportStep(element+" is entered with value "+text,"pass");
    }

    public void clickElement(By element) {
        waitForElement(element);
        driver.findElement(element).click();
        reportStep(element+" is clicked","pass");
    }

}




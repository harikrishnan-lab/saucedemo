package PageClass;

import org.openqa.selenium.By;
import utilityPackage.BaseTest;
import utilityPackage.SeleniumUtils;

public class CustomerDetailsPage extends SeleniumUtils {
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("posta-code");
    By continueButton = By.xpath("//input[@class='btn_primary cart_button']");
    public void enterFirstName(){
        driver.findElement(firstName).sendKeys("hari");
    }
    public void enterLastName(){
        driver.findElement(lastName).sendKeys("s");
    }
    public void enterPostalCode(){
        driver.findElement(postalCode).sendKeys("600100");
    }
    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }




}

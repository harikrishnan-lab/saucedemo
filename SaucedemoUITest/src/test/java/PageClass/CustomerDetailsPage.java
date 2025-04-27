package PageClass;

import org.openqa.selenium.By;
import utilityPackage.BaseTest;
import utilityPackage.SeleniumUtils;

public class CustomerDetailsPage extends SeleniumUtils {
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueButton = By.xpath("//input[@class='btn_primary cart_button']");

    public void enterFirstName() {
        enterText(firstName, "hari");
    }

    public void enterLastName() {
        enterText(lastName, "s");
    }

    public void enterPostalCode() {
        enterText(postalCode, "600100");
    }

    public void clickContinueButton() {
        clickElement(continueButton);
    }


}

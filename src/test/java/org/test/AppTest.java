package org.test;
import org.testng.annotations.Test;
import utilityPackage.selenium.ExtendReportListener;

public class AppTest extends ExtendReportListener {
    @Test()
    public void generalValidationOfE2E() {
    loginPage.login();
    productPage.selectBikeLight();
    productPage.selectOnesie();
    productPage.gotoCart();
    cartPage.clickCheckoutButton();
    customerDetailsPage.enterFirstName();
    customerDetailsPage.enterLastName();
    customerDetailsPage.enterPostalCode();
    customerDetailsPage.clickContinueButton();
    finishPage.clickFinishButton();
    }
}

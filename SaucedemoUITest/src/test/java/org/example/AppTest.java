package org.example;
import org.testng.annotations.Test;
import utilityPackage.BaseTest;

public class AppTest extends BaseTest {
    @Test
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

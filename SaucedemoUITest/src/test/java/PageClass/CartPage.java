package PageClass;

import org.openqa.selenium.By;
import utilityPackage.SeleniumUtils;

public class CartPage extends SeleniumUtils {
    By checkoutButton = By.xpath("//a[@class='btn_action checkout_button']");
    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }

}

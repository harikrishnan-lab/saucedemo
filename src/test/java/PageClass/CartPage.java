package PageClass;

import org.openqa.selenium.By;
import utilityPackage.selenium.seleniumUtil;

public class CartPage extends seleniumUtil {
    By checkoutButton = By.xpath("//a[@class='btn_action checkout_button']");
    public void clickCheckoutButton(){
        clickElement(checkoutButton);
    }

}

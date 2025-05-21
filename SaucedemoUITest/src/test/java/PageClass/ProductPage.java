package PageClass;

import org.openqa.selenium.By;
import utilityPackage.selenium.seleniumUtil;

public class ProductPage extends seleniumUtil.SeleniumUtils {
    By bikeLight = By.xpath("//div[text()='Sauce Labs Bike Light']" +
            greatGrandParent +
            "//button");
    By onesie = By.xpath("//div[text()='Sauce Labs Onesie']" +
            greatGrandParent +
            "//button");
    By cart = By.id("shopping_cart_container");

    public void selectBikeLight(){
        clickElement(bikeLight);
    }
    public void selectOnesie(){
        clickElement(onesie);
    }
    public void gotoCart() {
        clickElement(cart);
    }
}

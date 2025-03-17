package PageClass;

import org.openqa.selenium.By;
import utilityPackage.SeleniumUtils;

public class ProductPage extends SeleniumUtils {
    By bikeLight = By.xpath("//div[text()='Sauce Labs Bike Light']" +
            greatGrandParent +
            "//button");
    By onesie = By.xpath("//div[text()='Sauce Labs Onesie']" +
            greatGrandParent +
            "//button");
    By cart = By.id("shopping_cart_container");

    public void selectBikeLight(){
        driver.findElement(bikeLight).click();
    }
    public void selectOnesie(){
        driver.findElement(onesie).click();
    }
    public void gotoCart() {
        driver.findElement(cart).click();
    }
}

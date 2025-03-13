package PageClass;

import org.openqa.selenium.By;

import static utilityPackage.SeleniumUtils.driver;

public class FinishPage {
    By finishButton = By.xpath("//a[@class='btn_action cart_button']");
    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }

}

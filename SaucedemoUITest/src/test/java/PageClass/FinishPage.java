package PageClass;

import org.openqa.selenium.By;
import utilityPackage.SeleniumUtils;

import static utilityPackage.SeleniumUtils.driver;

public class FinishPage extends SeleniumUtils {
    By finishButton = By.xpath("//a[@class='btn_action cart_button']");

    public void clickFinishButton() {
        clickElement(finishButton);
    }

}

package PageClass;

import org.openqa.selenium.By;
import utilityPackage.selenium.seleniumUtil;

public class FinishPage extends seleniumUtil.SeleniumUtils {
    By finishButton = By.xpath("//a[@class='btn_action cart_button']");

    public void clickFinishButton() {
        clickElement(finishButton);
    }

}

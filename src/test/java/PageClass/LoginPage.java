package PageClass;

import org.openqa.selenium.By;
import utilityPackage.selenium.seleniumUtil;

public class LoginPage extends seleniumUtil.SeleniumUtils {
    By userName = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    public void login(){
        enterText(userName,"standard_user");
        enterText(password,"secret_sauce");
        clickElement(loginButton);
    }

}

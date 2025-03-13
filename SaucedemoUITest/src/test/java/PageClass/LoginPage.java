package PageClass;

import org.openqa.selenium.By;
import utilityPackage.SeleniumUtils;

public class LoginPage extends SeleniumUtils {
    By userName = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    public void login(){
        driver.findElement(userName).sendKeys("standard_user");
        driver.findElement(password).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();
    }

}

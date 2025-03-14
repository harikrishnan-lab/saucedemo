package utilityPackage;


import PageClass.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(ExtendReportListener.class)
public class BaseTest extends SeleniumUtils {
    public static LoginPage loginPage;
    public static ProductPage productPage;
    public static FinishPage finishPage;
    public static CustomerDetailsPage customerDetailsPage;
    public static CartPage cartPage;
@BeforeClass
    public static void setup() {
        initialiseDriver("chrome");
        launchUrl();
        loginPage = new LoginPage();
        productPage = new ProductPage();
        finishPage = new FinishPage();
        customerDetailsPage = new CustomerDetailsPage();
        cartPage = new CartPage();
    }
}

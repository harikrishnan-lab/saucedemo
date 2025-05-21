package utilityPackage.selenium;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Rerun implements IRetryAnalyzer {


    @Override
    public boolean retry(ITestResult iTestResult) {
        int failure = 0;
        int run = 5;
        if (failure < run) {
            failure++;
            return true;
        }

        return false;
    }

    public void method() {
        int failure = 0;
        int run = 5;
        if (failure < run) {
            failure++;
        }

    }
}
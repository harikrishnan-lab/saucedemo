package utilityPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.Date;

public class ExtendReportListener extends BaseTest implements ITestListener {
        private ExtentSparkReporter sparkReporter;
        private ExtentReports extent;
        private ExtentTest test;

        @Override
        public void onStart(ITestContext context) {
            // Creating ExtentHtmlReporter to write the report to a file
            sparkReporter = new ExtentSparkReporter("test-output/ExtentReport"+ System.currentTimeMillis() + ".html");

            // Creating an instance of ExtentReports
            extent = new ExtentReports();

            // Attaching the HtmlReporter to ExtentReports
            extent.attachReporter(sparkReporter);
            sparkReporter.config().setDocumentTitle("Selenium Test Report");
            sparkReporter.config().setReportName("Selenium Test Suite");
            sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK); // Optional
        }

        @Override
        public void onTestStart(ITestResult result) {
            // Creating a test in ExtentReports for the test method
            test = extent.createTest(result.getMethod().getMethodName());
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            // Marking the test as passed
            test.pass("Test Passed");
        }

        @Override
        public void onTestFailure(ITestResult result) {
            // Marking the test as failed and capturing the failure details
            test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(), result.getMethod().getMethodName()).build());
            test.getModel().setEndTime(getTime(result.getEndMillis()));
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            // Marking the test as skipped
            test.skip("Test Skipped");
        }

        @Override
        public void onFinish(ITestContext context) {
            // Flushing the report to save it
            extent.flush();
        }
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}

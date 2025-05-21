package utilityPackage.ReportUtil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilityPackage.BaseTest;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.Date;

public class ExtendReportListener extends BaseTest implements ITestListener {

    private ExtentSparkReporter sparkReporter;
    private ExtentReports extent;
    private ExtentTest test;
    private static String reportPath;

    @Override
    public void onStart(ITestContext context) {
        try {
            // Create report folder if not exists
            File reportDir = new File("test-output/Reports");
            if (!reportDir.exists()) {
                reportDir.mkdirs();
            }
            String timestamp = new java.text.SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            // Report path
            reportPath = "test-output/Reports/ExtentReport_" + timestamp + ".html";

            // Creating ExtentSparkReporter
            sparkReporter = new ExtentSparkReporter(reportPath);

            // Creating ExtentReports and attaching reporter
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // Reporter Configurations
            sparkReporter.config().setDocumentTitle("Selenium Test Report");
            sparkReporter.config().setReportName("Selenium Test Suite Report");
            sparkReporter.config().setTheme(Theme.DARK);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());

        // Attach screenshot if driver is not null
        if (driver != null) {
            String screenshotPath = takeScreenshot(result.getMethod().getMethodName());
            test.fail("Screenshot of failure",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

        // Automatically open the report in browser
        openReportInBrowser();
    }

    private String takeScreenshot(String methodName) {
        String screenshotPath = "test-output/Screenshots/" + methodName + "_" + System.currentTimeMillis() + ".png";
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(screenshotPath);
            destFile.getParentFile().mkdirs(); // create folder if not exists
            Files.copy(scrFile.toPath(), destFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    private void openReportInBrowser() {
        try {
            File htmlFile = new File(reportPath);
            if (htmlFile.exists()) {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } else {
                System.out.println("Report file not able to open automatically.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reportStep(String desc, String status, boolean bSnap) {
        synchronized (test) {
            // Start reporting the step and snapshot
            Media img = null;
            if (bSnap && !(status.equalsIgnoreCase("INFO") || status.equalsIgnoreCase("skipped"))) {
                img = MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build();
            }
            if (status.equalsIgnoreCase("pass")) {
                test.pass(desc, img);
            } else if (status.equalsIgnoreCase("fail")) { // additional steps to manage alert pop-up
                test.fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
                throw new RuntimeException("See the reporter for details.");
            } else if (status.equalsIgnoreCase("warning")) {
                test.warning(desc, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
            } else if (status.equalsIgnoreCase("skipped")) {
                test.skip("The test is skipped due to dependency failure");
            } else if (status.equalsIgnoreCase("INFO")) {
                test.info(desc, img);
            }
        }
    }
    public void reportStep(String desc, String status) {
        Log.info(desc);
        reportStep(desc,status,true);
    }
}

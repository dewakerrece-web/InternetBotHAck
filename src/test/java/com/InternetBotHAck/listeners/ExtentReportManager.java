package com.InternetBotHAck.listeners;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class ExtentReportManager implements ITestListener {
    ExtentReports extent;
    ExtentTest test;
    public void onStart(ITestContext context) {
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/TestReport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }
    public void onTestFailure(ITestResult result) {
        test.fail("Test Failed: " + result.getThrowable());

        String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = "screenshots/" + result.getName() + "_" + time + ".png";

        try {
            Object obj = result.getInstance();
            WebDriver driver = (WebDriver) obj.getClass()
                    .getDeclaredField("driver").get(obj);
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(screenshotPath));
            test.addScreenCaptureFromPath("../" + screenshotPath);
        } catch (Exception e) {
            System.out.println("Could not attach screenshot: " + e.getMessage());
        }
    }
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
    }
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
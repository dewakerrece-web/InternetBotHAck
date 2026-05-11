package com.InternetBotHAck.listeners;

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
    }

    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
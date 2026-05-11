package com.InternetBotHAck.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    public void onTestFailure(ITestResult result) {
        Object obj = result.getInstance();
        WebDriver driver = null;

        try {
            driver = ((com.InternetBotHAck.base.BasePage) obj).driver;
        } catch (Exception e) {
            System.out.println("Could not get driver: " + e.getMessage());
        }

        if (driver != null) {
            String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = "screenshots/" + result.getName() + "_" + time + ".png";
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(src, new File(fileName));
                System.out.println("Screenshot saved: " + fileName);
            } catch (IOException e) {
                System.out.println("Screenshot failed: " + e.getMessage());
            }
        }
    }

    public void onTestStart(ITestResult result) {}
    public void onTestSuccess(ITestResult result) {}
    public void onTestSkipped(ITestResult result) {}
    public void onFinish(ITestContext context) {}
    public void onStart(ITestContext context) {}
}
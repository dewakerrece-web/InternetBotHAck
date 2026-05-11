package com.InternetBotHAck.tests;

import com.InternetBotHAck.base.BasePage;
import com.InternetBotHAck.pages.AlertPage;
import com.InternetBotHAck.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AlertTest extends BasePage {

    AlertPage ap;
    ConfigReader config;
    String url;

    @BeforeMethod
    public void setUp() throws IOException {
        config = new ConfigReader();
        url = config.getBaseUrl();
        initDriver();
        driver.get(url + "/javascript_alerts");
        ap = new AlertPage(driver);
    }

    @Test
    public void testJsAlert() {
        ap.clickAlertAndAccept();
        String result = ap.getResultText();
        Assert.assertTrue(result.contains("You successfully clicked an alert"));
    }

    @Test
    public void testJsConfirm() {
        ap.clickConfirmAndDismiss();
        String result = ap.getResultText();
        Assert.assertTrue(result.contains("You clicked: Cancel"));
    }

    @Test
    public void testJsPrompt() {
        ap.clickPromptAndEnterText("hello");
        String result = ap.getResultText();
        Assert.assertTrue(result.contains("hello"));
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
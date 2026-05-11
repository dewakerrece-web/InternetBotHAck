package com.InternetBotHAck.tests;

import com.InternetBotHAck.base.BasePage;
import com.InternetBotHAck.pages.DynamicPage;
import com.InternetBotHAck.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class DynamicTest extends BasePage {

    DynamicPage dp;
    ConfigReader config;
    String url;

    @BeforeMethod
    public void setUp() throws IOException {
        config = new ConfigReader();
        url = config.getBaseUrl();
        initDriver();
        driver.get(url + "/dynamic_loading/1");
        dp = new DynamicPage(driver);
    }

    @Test
    public void testDynamicLoading() {
        dp.clickStart();
        String text = dp.getLoadedText();
        Assert.assertEquals(text, "Hello World!");
    }

    @Test
    public void testPageRefresh() {
        dp.refreshPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("dynamic_loading"));
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
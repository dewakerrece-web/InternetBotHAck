package com.InternetBotHAck.tests;
import com.InternetBotHAck.base.BasePage;
import com.InternetBotHAck.pages.DynamicPage;
import com.InternetBotHAck.utils.ConfigReader;
import org.openqa.selenium.By;
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
    public void testPageRefresh() throws IOException {
        driver.get(new ConfigReader().getBaseUrl() + "/disappearing_elements");
        dp.refreshPage();
        boolean hasElements = driver.findElements(
                By.xpath("//ul/li")).size() > 0;
        Assert.assertTrue(hasElements);
    }
    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
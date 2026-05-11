package com.InternetBotHAck.tests;

import com.InternetBotHAck.base.BasePage;
import com.InternetBotHAck.pages.CheckboxPage;
import com.InternetBotHAck.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckboxTest extends BasePage {

    CheckboxPage cp;
    ConfigReader config;
    String url;

    @BeforeMethod
    public void setUp() throws IOException {
        config = new ConfigReader();
        url = config.getBaseUrl();
        initDriver();
        driver.get(url + "/checkboxes");
        cp = new CheckboxPage(driver);
    }

    @Test
    public void testCheckbox1() {
        boolean before = cp.isCheckbox1Selected();
        cp.clickCheckbox1();
        boolean after = cp.isCheckbox1Selected();
        Assert.assertNotEquals(before, after);
    }

    @Test
    public void testCheckbox2() {
        boolean before = cp.isCheckbox2Selected();
        cp.clickCheckbox2();
        boolean after = cp.isCheckbox2Selected();
        Assert.assertNotEquals(before, after);
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
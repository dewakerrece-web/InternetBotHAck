package com.InternetBotHAck.tests;
import com.InternetBotHAck.base.BasePage;
import com.InternetBotHAck.pages.CheckboxPage;
import com.InternetBotHAck.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
public class DropdownTest extends BasePage {
    CheckboxPage cp;
    ConfigReader config;
    String url;
    @BeforeMethod
    public void setUp() throws IOException {
        config = new ConfigReader();
        url = config.getBaseUrl();
        initDriver();
        driver.get(url + "/dropdown");
        cp = new CheckboxPage(driver);
    }
    @Test
    public void testDropdownOption1() {
        cp.selectDropdownOption("Option 1");
        String selected = cp.getSelectedOption();
        Assert.assertEquals(selected, "Option 1");
    }
    @Test
    public void testDropdownOption2() {
        cp.selectDropdownOption("Option 2");
        String selected = cp.getSelectedOption();
        Assert.assertEquals(selected, "Option 2");
    }
    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
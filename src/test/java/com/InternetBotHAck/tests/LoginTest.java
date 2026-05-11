package com.InternetBotHAck.tests;
import com.InternetBotHAck.base.BasePage;
import com.InternetBotHAck.pages.LoginPage;
import com.InternetBotHAck.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class LoginTest extends BasePage {
    LoginPage lp;
    ConfigReader config;
    String url;
    @BeforeMethod
    public void setUp() throws IOException {
        config = new ConfigReader();
        url = config.getBaseUrl();
        initDriver();
        driver.get(url + "/login");
        lp = new LoginPage(driver);
    }
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
                {"tomsmith", "SuperSecretPassword!", true},
                {"wronguser", "wrongpass", false}
        };
    }
    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, boolean isValid) {
        lp.enterUsername(username);
        lp.enterPassword(password);
        lp.clickLogin();
        String msg = lp.getFlashMessage();
        if (isValid) {
            Assert.assertTrue(msg.contains("You logged into a secure area!"));
        } else {
            Assert.assertTrue(msg.contains("Your username is invalid!"));
        }
    }
    @Test
    public void testLogout() throws IOException {
        lp.enterUsername("tomsmith");
        lp.enterPassword("SuperSecretPassword!");
        lp.clickLogin();
        lp.clickLogout();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

}
package com.InternetBotHAck.tests;
import com.InternetBotHAck.base.BasePage;
import com.InternetBotHAck.pages.UploadPage;
import com.InternetBotHAck.utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
public class UploadTest extends BasePage {
    UploadPage up;
    ConfigReader config;
    String url;
    @BeforeMethod
    public void setUp() throws IOException {
        config = new ConfigReader();
        url = config.getBaseUrl();
        initDriver();
        driver.get(url + "/upload");
        up = new UploadPage(driver);
    }
    @Test
    public void testPageTitle() {
        String title = up.getPageTitle();
        //Assert.assertEquals(title, "Wrong title");
        Assert.assertEquals(title,"File Uploader");
    }
    @Test
    public void testFileUpload() {
        String filePath = System.getProperty("user.dir") + "\\testfiles\\testupload.txt";
        up.uploadFile(filePath);
        String uploadedFile = up.getUploadedFileName();
        Assert.assertEquals(uploadedFile, "testupload.txt");
    }
    @Test
    public void testUploadPageFormVisible() {
        boolean uploadVisible = driver.findElement(By.id("file-upload")).isDisplayed();
        boolean btnVisible = driver.findElement(By.id("file-submit")).isDisplayed();
        Assert.assertTrue(uploadVisible);
        Assert.assertTrue(btnVisible);
    }
    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
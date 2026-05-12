package com.InternetBotHAck.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadPage {
    WebDriver driver;
    By uploadInput=By.id("file-upload");
    By uploadButton=By.id("file-submit");
    By uploadedFileName=By.id("uploaded-files");
    By pageTitle=By.tagName("h3");

    public UploadPage(WebDriver driver){
        this.driver=driver;
    }
    public void uploadFile(String filepath){
        driver.findElement(uploadInput).sendKeys(filepath);
        driver.findElement(uploadButton).click();
    }
    public String getUploadedFileName(){
        return driver.findElement(uploadedFileName).getText();
    }
    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }
    public boolean isUploadFormVisible() {
        return driver.findElement(By.id("file-upload")).isDisplayed();
    }

    public boolean isUploadBtnVisible() {
        return driver.findElement(By.id("file-submit")).isDisplayed();
    }

}

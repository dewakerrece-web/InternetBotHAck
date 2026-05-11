package com.InternetBotHAck.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicPage {
    WebDriver driver;
    By startbtn=By.xpath("//button[text()='Start']");
    By loadedText=By.xpath("//div[@id='finish']/h4");
    public DynamicPage(WebDriver driver){
        this.driver=driver;
    }
    public void clickStart(){
        driver.findElement(startbtn).click();
    }
    public String getLoadedText(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadedText));
        return driver.findElement(loadedText).getText();
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }
}

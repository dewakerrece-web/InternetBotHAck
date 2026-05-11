package com.InternetBotHAck.pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AlertPage {
    WebDriver driver;
    By jsAlertButton=By.xpath("//button[text()='Click for JS Alert']");
    By jsConfirmButton=By.xpath("//button[text()='Click for JS Confirm']");
    By jsPromptButton=By.xpath("//button[text()='Click for JS Prompt']");
    By resultText=By.id("result");
    public AlertPage(WebDriver driver) {
        this.driver=driver;
    }
    public void clickAlertAndAccept() {
        driver.findElement(jsAlertButton).click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    public void clickConfirmAndDismiss() {
        driver.findElement(jsConfirmButton).click();
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
    }
    public void clickPromptAndEnterText(String text) {
        driver.findElement(jsPromptButton).click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }
    public String getResultText() {

        return driver.findElement(resultText).getText();
    }
}
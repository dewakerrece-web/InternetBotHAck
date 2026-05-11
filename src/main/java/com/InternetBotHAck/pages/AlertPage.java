package com.InternetBotHAck.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage {
    WebDriver driver;

    By jsAlertButton= By.xpath("//button[text()='Click for JS Alert']");
    By jsConfirmButton=By.xpath("//button[text()='Click for JS Confirm']");
    By jsPromptButton=By.xpath("//button[text()='Click for JS Prompt']");
    By resultText=By.id("result");

    public AlertPage(WebDriver driver){
        this.driver=driver;
    }

}

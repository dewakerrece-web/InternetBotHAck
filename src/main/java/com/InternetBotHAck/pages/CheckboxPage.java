package com.InternetBotHAck.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxPage {
    WebDriver driver;
    By checkbox1=By.xpath("//input[@type='checkbox'][1]");
    By checkbox2=By.xpath("//input[@type='checkbox'][2]");
    By dropdown=By.id("dropdown");

    public CheckboxPage(WebDriver driver){

        this.driver=driver;
    }
    public boolean isCheckbox1Selected(){

        return driver.findElement(checkbox1).isSelected();
    }
    public void clickCheckbox1(){

        driver.findElement(checkbox1).click();
    }
    public boolean isCheckbox2Selected(){

        return driver.findElement(checkbox2).isSelected();
    }
    public void clickCheckbox2(){

        driver.findElement(checkbox2).click();
    }
    public void selectDropdownOption(String optionText){
        driver.findElement(dropdown).click();
        By option=By.xpath("//option[text()='"+optionText+"']");
        driver.findElement(option).click();
    }
    public String getSelectedOption(){
        By selectedOption = By.xpath("//select[@id='dropdown']/option[@selected]");
        return driver.findElement(selectedOption).getText();
    }
    public int getDropdownOptionsCount() {
        return driver.findElements(
                By.xpath("//select[@id='dropdown']/option")).size();
    }



}

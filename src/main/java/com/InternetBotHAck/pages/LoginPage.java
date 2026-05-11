package com.InternetBotHAck.pages;
import com.InternetBotHAck.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class LoginPage extends BasePage {
    WebDriver driver;
    By usernameField=By.id("username");
    By passwordField=By.id("password");
    By loginButton=By.cssSelector("button[type='submit']");
    By flashMessage=By.id("flash");
    By logoutButton=By.cssSelector("a[href='/logout']");
    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }
    public void enterUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    public String getFlashMessage() {
        waitForElement(driver.findElement(flashMessage));
        return driver.findElement(flashMessage).getText();
    }
    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }
}
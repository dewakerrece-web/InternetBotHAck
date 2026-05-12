package com.InternetBotHAck.base;
import com.InternetBotHAck.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
public class BasePage {
    public WebDriver driver;
    protected WebDriverWait wait;
    public void initDriver() throws IOException {
        ConfigReader config = new ConfigReader();
        String browser = config.getBrowser();
        int timeout = config.getTimeout();

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }
    public void goToUrl(String url){
        driver.get(url);
    }
    public void waitForElement(WebElement element){
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
        w.until(ExpectedConditions.visibilityOf(element));
    }
    public void quitDriver(){
        if(driver != null){
            driver.quit();
        }
    }
}

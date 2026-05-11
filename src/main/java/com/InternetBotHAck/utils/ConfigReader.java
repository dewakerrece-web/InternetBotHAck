package com.InternetBotHAck.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    public ConfigReader() throws IOException {
        properties=new Properties();
        FileInputStream fip=new FileInputStream("src/main/resources/config.properties");
        properties.load(fip);
    }
    public String getBrowser(){
        return properties.getProperty("browser");
    }
    public String getBaseUrl(){
        return properties.getProperty("base.url");
    }
    public int getTimeout(){
        return Integer.parseInt(properties.getProperty("timeout"));
    }
}

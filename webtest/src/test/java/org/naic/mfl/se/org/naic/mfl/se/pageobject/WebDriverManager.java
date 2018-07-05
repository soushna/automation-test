package org.naic.mfl.se.org.naic.mfl.se.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    private static WebDriver driver;

    public static WebDriver initializeWebDriver(){
        String chromeDriverPath = FrameworkConstants.CHROMEdRIVERPATH;
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver getDriver(){
        if(driver == null){
            driver = initializeWebDriver();
        }
        return driver;
    }

    public static void killDriver(){
        if (driver != null){
            driver.close();
            driver.quit();
        }
    }
}

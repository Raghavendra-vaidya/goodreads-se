package com.goodreadsSe.configurations;

import com.goodreadsSe.Utilities.GetData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.collections4.Get;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class CreateWebDriver {
    public  static WebDriver driver;
    public  static String url = GetData.fromProperties("src/main/resources/config.properties","URL");
    public static String implicTimeString = GetData.fromProperties("src/main/resources/config.properties","implicitWaitTime");
    public static Integer implicitWaitTime = Integer.valueOf(implicTimeString);

    public static WebDriver instance(String browser){

        /***Handle different browser machanism**/
        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions cops = new ChromeOptions();
            cops.addArguments("--headless");
            driver = new ChromeDriver(cops);

        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions fops = new FirefoxOptions();
            fops.addArguments("--headless");
            driver = new FirefoxDriver(fops);

        }
        /***After initiation of browser instance, land user to the required application.**/
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
        return driver;
    }


}

package com.goodreadsSe.ui;

import com.goodreadsSe.Utilities.GetData;
import com.goodreadsSe.Utilities.JsonUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage extends Requirements{
    WebDriver driver;

    /***identifiers for webelements**/
    String pagecontentIdentifier = jsonFileObject.get("landingPageContent").toString();
    String signInIdentifier = jsonFileObject.get("signIn").toString();



    /***constructor to initialize the webelements**/
    public LandingPage(WebDriver driver){
        this.driver = driver;
    }


    public void waitForPageToLoad(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitTime));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(pagecontentIdentifier)));
    }

    /***POM methods**/
    public WebElement getSignInLink(){
        return driver.findElement(By.xpath(signInIdentifier));
    }

    /***POM action methods**/

    public void clickOnSignIn(){
        getSignInLink().click();
    }

}

package com.goodreadsSe.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage extends Requirements {

    WebDriver driver;


    /***identifiers for webelements**/
    String authScreenContent = jsonFileObject.get("authScreenContent").toString();
    String signInWithEmail = jsonFileObject.get("signInWithEmail").toString();
    String emailIdentifier = jsonFileObject.get("email_name").toString();
    String passwordIdentifier = jsonFileObject.get("password_name").toString();
    String signInSubmitIdentifier = jsonFileObject.get("signInSubmit_id").toString();


    /***constructor to initialize the webelements**/

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }


    public WebElement getSignInWithEmail(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(signInWithEmail)));
        return driver.findElement(By.xpath(signInWithEmail));
    }

    public void waitForSignInPageToLoad(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitTime));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(authScreenContent)));
    }

    /***POM methods**/
    public WebElement getEmailField(){
        return driver.findElement(By.name(emailIdentifier));
    }

    public WebElement getPasswordField(){
        return driver.findElement(By.name(passwordIdentifier));
    }

    public WebElement getSignInSubmit(){
        return driver.findElement(By.id(signInSubmitIdentifier));
    }

    /***POM action methods**/

    public void clickOnSignInWithEmail(){
        getSignInWithEmail().click();
    }

    public void enterEmail(String email){
        getEmailField().sendKeys(email);
    }

    public void enterPassword(String password){
        getPasswordField().sendKeys(password);
    }
    public void  clickOnSignIn(){
        getSignInSubmit().click();
    }


}

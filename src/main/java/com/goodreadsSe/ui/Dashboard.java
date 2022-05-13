package com.goodreadsSe.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dashboard  extends Requirements{

    WebDriver driver;

    /***identifiers for webelements**/
    String htmlBody = "//body";
    String searchField = jsonFileObject.get("searchBar").toString();
    String markToRead = jsonFileObject.get("wantToRead").toString();
    String myBooks = jsonFileObject.get("myBooks").toString();
    String removeBookFromList = jsonFileObject.get("removeBookFromList").toString();

    String profile = jsonFileObject.get("profile").toString();
    String signOutLink = jsonFileObject.get("signOut").toString();

    String searchResultText = jsonFileObject.get("searchResultText").toString();

    String removeSucessMessage = jsonFileObject.get("removeMessage").toString();


    /***constructor to initialize the webelements**/
    public Dashboard(WebDriver driver){
        this.driver = driver;
    }


    public void waitForPageToLoad(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitTime));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(htmlBody)));
    }


    /***POM methods**/
    public WebElement getSearchField(){
        return driver.findElement(By.xpath(searchField));
    }

    public WebElement getMarkToRead(){
        return driver.findElement(By.xpath(markToRead));
    }

    public WebElement getMyBooksLink(){
        return  driver.findElement(By.linkText(myBooks));
    }

    public WebElement removebookFromList(){
        return driver.findElement(By.xpath(removeBookFromList));
    }

    public WebElement myProfile(){
        return driver.findElement(By.xpath(profile));
    }

    public WebElement signOutLink(){
        return driver.findElement(By.xpath(signOutLink));
    }

    public WebElement getSearchResultText(){
        return driver.findElement(By.xpath(searchResultText));
    }


    /***POM action methods**/

    public void searchBooks(String bookName){
        getSearchField().sendKeys(bookName, Keys.ENTER);
    }

    public void markBookToRead(){
        getMarkToRead().click();
    }

    public void  navigateToMyBooks(){
        getMyBooksLink().click();
    }

    public void removeBookFromMyList(){
        removebookFromList().click();
    }

    public void goToProfie(){
        myProfile().click();
    }

    public void signOut(){
        signOutLink().click();
    }

    public boolean isSearchResultDisplayed(){
       return getSearchResultText().isDisplayed();
    }

    public boolean isRemoveSuccessMessageDisplayed(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(removeSucessMessage)));
        return driver.findElement(By.xpath(removeSucessMessage)).isDisplayed();
    }




}

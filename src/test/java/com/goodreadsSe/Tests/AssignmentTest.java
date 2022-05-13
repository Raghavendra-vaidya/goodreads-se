package com.goodreadsSe.Tests;

import com.goodreadsSe.Utilities.Base;
import com.goodreadsSe.Utilities.JsonUtils;
import com.goodreadsSe.Utilities.ProjectUtility;
import com.goodreadsSe.configurations.CreateWebDriver;
import com.goodreadsSe.ui.Dashboard;
import com.goodreadsSe.ui.LandingPage;
import com.goodreadsSe.ui.SignInPage;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class AssignmentTest extends Base {

    public LandingPage landing;
    public SignInPage signin;
    public Dashboard dashboard;

    SoftAssert softAssert = new SoftAssert();

    JSONObject testDataFile = JsonUtils.getJsonFileObj("src/test/resources/testData.json");
    String  bookName = testDataFile.get("bookNameSearch").toString();

    @BeforeSuite
    public void clearScreenshots(){
        /***clear out the previous run test screenshots**/
        ProjectUtility.deleteScreenShots();
    }


    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser)
    {
        driver = CreateWebDriver.instance(browser);
        landing = new LandingPage(driver);
        signin = new SignInPage(driver);
        dashboard = new Dashboard(driver);

    }

    @Test(description = "Login to goodreads and search book, mark it to read, remove and logout")
    public void testGoodreads(){
        /***Landing and navigation to login**/
        landing.waitForPageToLoad();
        landing.clickOnSignIn();

        /***sign in activity**/
        signin.clickOnSignInWithEmail();
        signin.waitForSignInPageToLoad();
        softAssert.assertTrue(signin.getEmailField().isDisplayed());
        softAssert.assertTrue(signin.getPasswordField().isDisplayed());
        signin.enterEmail("rkvaidya58@gmail.com");
        signin.enterPassword("Vidyaganesha");
        signin.clickOnSignIn();

        /***Search book and mark it to read**/
        dashboard.waitForPageToLoad();
        softAssert.assertTrue(dashboard.getSearchField().isDisplayed());
        dashboard.searchBooks(bookName);
        softAssert.assertTrue(dashboard.isSearchResultDisplayed());
        dashboard.markBookToRead();
        try {Thread.sleep(4000);}
        catch (InterruptedException e) {e.printStackTrace();}
        dashboard.navigateToMyBooks();
        dashboard.removeBookFromMyList();
        driver.switchTo().alert().accept();

        /***Final assertion**/
        Assert.assertTrue(dashboard.isRemoveSuccessMessageDisplayed(), "Removing book from the list failed");

    }

    @AfterMethod
    public void tearDown(){
        dashboard.goToProfie();
        dashboard.signOut();
        driver.quit();
    }



}

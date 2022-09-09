package com.goodreadsSe.Utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {


    /***Override onTestFailure to handle screenshot mechanism**/
    @Override
    public void onTestFailure(ITestResult arg0) {
        ProjectUtility.captureScreenshot(Base.driver, arg0);
    }
}

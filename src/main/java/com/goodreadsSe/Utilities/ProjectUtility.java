package com.goodreadsSe.Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.regex.Pattern;

public class ProjectUtility {

    public void captureScreenshot(WebDriver driver, ITestResult result)
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenShotSource = ts.getScreenshotAs(OutputType.FILE);

        String testMethodName = result.getName();
        String testPackageName = result.getInstanceName();
        String[] arrayOfPathDetails = testPackageName.split(Pattern.quote("."));
        String testClassName = arrayOfPathDetails[arrayOfPathDetails.length-1];

        File destinationFolder = new File("./screenshots/"+testClassName+"/");
        File outputScreenshotDestination = new File("./screenshots/"+testClassName+"/"+testMethodName+".jpg");

        try {

            if (!destinationFolder.exists())
            {

                destinationFolder.mkdir();
                Files.copy(screenShotSource.toPath(), outputScreenshotDestination.toPath(), StandardCopyOption.REPLACE_EXISTING);

            } else if (destinationFolder.exists() && !outputScreenshotDestination.exists())
            {

                Files.copy(screenShotSource.toPath(), outputScreenshotDestination.toPath(), StandardCopyOption.REPLACE_EXISTING);

            } else {
                return;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void deleteScreenShots(){

        File screenshotFolder = new File("screenshots");
        if (screenshotFolder.exists() && screenshotFolder.list().length>0){
            String[] folderContents = screenshotFolder.list();
            for (String folderContent: folderContents)
            {
                FileUtils.deleteQuietly(new File("screenshots/"+folderContent));
            }
        }
        else return;

    }
}

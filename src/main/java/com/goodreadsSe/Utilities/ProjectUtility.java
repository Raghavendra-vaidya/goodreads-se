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

    public static void captureScreenshot(WebDriver driver, ITestResult result)
    {
        /***1.Capture screenshot as a type FILE**/
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenShotSource = ts.getScreenshotAs(OutputType.FILE);

        /***2.get the details of the test that is running.
         * ex: method name, class name **/

        String testMethodName = result.getName();
        String testPackageName = result.getInstanceName();
        String[] arrayOfPathDetails = testPackageName.split(Pattern.quote("."));
        String testClassName = arrayOfPathDetails[arrayOfPathDetails.length-1];


        File destinationFolder = new File("./screenshots/"+testClassName+"/");
        File outputScreenshotDestination = new File("./screenshots/"+testClassName+"/"+testMethodName+".jpg");

        /***3.check if the directory named after a class of execution exists,
         * if so, create a screenshot under a directory named after classname with the name of failed test method **/
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

        /***Delete screenshots method to clear out the previous run test screenshots. To be invoked before the suite execution **/

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

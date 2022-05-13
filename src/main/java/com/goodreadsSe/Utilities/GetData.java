package com.goodreadsSe.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class GetData {


    /*** Below method will read key from a properties file at give path and return the value for the requested key**/

    public static String fromProperties(String filePath, String key){
        String requiredValue = null;
        File fileObj = new File(filePath);
        try
        {
            FileInputStream fis = new FileInputStream(fileObj);
            Properties propertiesFile = new Properties();
            propertiesFile.load(fis);
            requiredValue = propertiesFile.getProperty(key).toString();
        }
        catch (Exception e){e.printStackTrace();}
        return requiredValue;

    }

}

package com.goodreadsSe.ui;

import com.goodreadsSe.Utilities.GetData;
import com.goodreadsSe.Utilities.JsonUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Requirements {
    WebDriverWait wait;
    String explicitWait = GetData.fromProperties("src/main/resources/config.properties","explicitWaitTime");
    Integer explicitWaitTime = Integer.valueOf(explicitWait);

    JSONObject jsonFileObject = JsonUtils.getJsonFileObj("src/main/resources/identifiers.json");
}

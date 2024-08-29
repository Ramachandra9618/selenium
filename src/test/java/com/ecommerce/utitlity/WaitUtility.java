package com.ecommerce.utitlity;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.ecommerce.base.BaseClass.driver;

public class WaitUtility {
    public void LoadingWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement suggestion = wait.until(ExpectedConditions.visibilityOf(element));
        suggestion.click();
    }
}


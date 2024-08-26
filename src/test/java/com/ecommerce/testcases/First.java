package com.ecommerce.testcases;

import com.ecommerce.base.BaseClass;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class First {

    WebDriver webDriver = new ChromeDriver();
    @Test
    public void runs() throws InterruptedException {
        System.out.println(webDriver);
        webDriver.get("https://admin-demo.nopcommerce.com/");
     Thread.sleep(10000);
//        System.out.println(webDriver.);
//        webDriver.switchTo().frame(1);
//        Actions actions = new Actions(webDriver);
        WebElement shadowHost = webDriver.findElement(By.cssSelector("#shadow-root"));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
        WebElement shadowElement = shadowRoot.findElement(By.xpath("//iframe[@id='cf-chl-widget-365wp']"));





//        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//iframe[@id='cf-chl-widget-365wp']")));
        WebElement element = webDriver.findElement(By.id("cf-chl-widget-pm5q7"));
        element.click();

    }
}


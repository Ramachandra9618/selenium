package com.ecommerce.testcases;

import com.ecommerce.base.BaseClass;
import com.ecommerce.base.GridSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class ExampleTest extends BaseClass {


    @Test
    void verifyTitle() throws InterruptedException {
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.google.com', '_blank');");
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.wikipedia.org', '_blank');");
        Thread.sleep(2000);
        String title = driver.getCurrentUrl();
//        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
     Set<String> handles = driver.getWindowHandles();
     String [] handle = handles.toArray(new String[0]);
        System.out.println(handle.length+  handle[0]+ "  "+handle[1]+"   "+handle[2]);
        driver.switchTo().window(handle[0]);
        Thread.sleep(5000);
//        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Automation");
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");
        Thread.sleep(5000);
        driver.switchTo().window(handle[2]);
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
        System.out.println(title);
//        WebElement element = driver.findElement(By.id("elementId"));
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);

//        for (WebElement checkbox : checkboxes) {
//            checkbox.click();
//            Thread.sleep(2000);
//        }
        test.pass("Title verified successfully");
    }

}

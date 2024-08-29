package com.ecommerce.utitlity;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class ActionUtility {

    WebDriver driver;

    public ActionUtility(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickEnterButton() throws AWTException {
        Robot robot = new Robot();
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void enterDataByKeyboard(String data) throws AWTException {
        Robot robot = new Robot();
        robot.delay(2000);
        for (char ch : data.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(ch);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }
    }

    public void robotMouseOn(int x, int y) throws AWTException {
        Robot robot = new Robot();
        robot.delay(2000);
        robot.mouseMove(x, y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void robotClick(int x, int y) throws AWTException {
        Robot robot = new Robot();
        robot.delay(2000);
        robot.mouseMove(x, y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }


    public void screenShot(String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        File destFile = new File("screenshots/" + name + "_" + timestamp + "_screenshot.png");
        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved successfully at: " + destFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mouseOnCategory(String category) throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        WebElement categoryElement = driver.findElement(By.xpath("//span[contains(text(), '" + category + "')]"));
        actions.moveToElement(categoryElement).perform();
        Thread.sleep(2000);
    }

    public void mouseOnSubCategory(String subCategory) {
        WebElement subCategoryElement = driver.findElement(By.partialLinkText(subCategory));
        Actions actions = new Actions(driver);
        actions.moveToElement(subCategoryElement).perform();
    }
    public void mouseClickOnType(String type) {
        WebElement subCategoryElement = driver.findElement(By.partialLinkText(type));
        Actions actions = new Actions(driver);
        subCategoryElement.click();
    }

    public void handleTab(){
        String originalTab = driver.getWindowHandle();
        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            System.out.println(tab);
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }


}


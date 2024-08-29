package com.ecommerce.pageObjects;

import com.ecommerce.actiondriver.Action;
import com.ecommerce.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class TravelPage extends BaseClass {

    //wN1kJt U1LCmH
    @FindBy(how = How.XPATH, using = "//button[@class = 'pl8ttv']")
    public List<WebElement> selectDate;
    Action action = new Action();
    @FindBy(how = How.XPATH, using = "//input[@name='0-departcity']")
    WebElement fromInput;
    @FindBy(how = How.XPATH, using = "//input[@name='0-arrivalcity']")
    WebElement toInput;
    @FindBy(how = How.XPATH, using = "//div/span[1]")
    WebElement DropDown;
    @FindBy(how = How.XPATH, using = "//input[@name='0-datefrom']")
    WebElement departDateOption;
    @FindBy(how = How.XPATH, using = "//button[@class='xSWdQ- azBkHf']")
    WebElement doneButton;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='SEARCH']")
    WebElement search;
    @FindBy(how = How.XPATH, using = "//div[@class='_5WWQqg']")
    WebElement datePicker;
    private WebDriver driver;

    public TravelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFromInput(String name) {
        fromInput.sendKeys(name);
    }

    public void enterToInput(String name) {
        toInput.sendKeys(name);
    }

    public void selectFirstOne(String city) {
        driver.findElement(By.xpath("//span[normalize-space()='" + city + "']")).click();
    }

    public void clickOnDate() {
        departDateOption.click();
    }

    public void selectDate() {
//        action.click(driver, selectDate.get(30));
        List<WebElement> dateElement = (List<WebElement>) driver.findElement(By.xpath("//button[text()='10']"));
        dateElement.get(1).click();
    }

    public boolean isSelectDate() {
        return action.isDisplayed(driver, selectDate.get(30));
    }

    public void clickDone() {
        doneButton.click();
    }

    public void clickonSearch() {
        search.click();
    }


    public void datePicker(String targetMonth, String targetYear, String targetDay) throws InterruptedException {
        // Wait until the date picker is visible
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(datePicker));

        List<WebElement> mmyy = driver.findElements(By.xpath("//div[@class='_1w7bXX']"));
        List<String> months = new LinkedList<>();
        List<String> years = new LinkedList<>();
        for (WebElement i : mmyy) {
            months.add(i.getText().split(" ")[0]);
            years.add(i.getText().split(" ")[1]);
        }

        while (!(months.contains("March") && (years.contains("2025")))) {
            System.out.println(months );
            System.out.println(years);
            driver.findElement(By.xpath("//div[@class='au1mSN']//button[@class='R0r93E']")).click();

            mmyy = driver.findElements(By.xpath("//div[@class='_1w7bXX']"));
              months.clear();
              years.clear();
            for (WebElement i : mmyy) {
                months.add(i.getText().split(" ")[0]);
                years.add(i.getText().split(" ")[1]);
            }
        }

        if (months.get(0).equals(targetMonth)) {
            driver.findElement(By.xpath("//button[text()='" + targetDay + "']")).click();
        } else {
            driver.findElement(By.xpath("(//button[text()='" + targetDay + "'])[2]")).click();
        }
    }


}

package com.ecommerce.pageObjects;

import com.ecommerce.actiondriver.Action;
import com.ecommerce.base.BaseClass;
import com.ecommerce.base.GridSetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LandingPage extends GridSetUp {


    private WebDriver driver;
    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
    Action action = new Action();
    @FindBy(how = How.XPATH, using = "//img[@title='Flipkart']")  WebElement logo;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Login']") WebElement login;
    @FindBy(how = How.XPATH, using = "//span[@class='_1Mikcj']") WebElement newRegister;
    @FindBy(how = How.XPATH, using = ("//input[@placeholder='Search for Products, Brands and More']")) WebElement searchBar;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']//*[name()='svg']") WebElement searchButton;
    @FindBy(how = How.XPATH, using = "//span[@class='_1Mikcj']")WebElement signUp;
    @FindBy(how = How.XPATH, using = "//ul[@class='_3YjYK7 ecs1XG']//a") WebElement dropDown;





    public boolean isLogo(){
        System.out.println(driver+"     "+logo);
        return action.findElement(driver, logo);
    }

    public String enterSerch(String data){
        action.type(searchBar, data);
        action.click(driver, searchButton);
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.getCurrentUrl();
    }

    public boolean isLogin(){
        boolean flag = action.findElement(driver, login);
        return flag;
    }
    public String clickSignUp(){
        action.click(driver, signUp);
        return driver.getCurrentUrl();
    }

    public String clickLogin(){
            action.click(driver, login);
        return driver.getCurrentUrl();
    }

    public String clickRegister(){
        action.click(driver, newRegister);
        return driver.getCurrentUrl();
    }

    public void checkDropdown(){
        action.isDropdownDisplayed(driver, dropDown);
    }
    public void mouseOn(){
        action.moveToElement(driver, login);

    }
}

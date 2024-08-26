package com.ecommerce.pageObjects;

import com.ecommerce.actiondriver.Action;
import com.ecommerce.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class RegisterPage extends BaseClass {


    Action action = new Action();

    @FindBy(how = How.XPATH, using = "//input[@class='r4vIwl BV+Dqf']") WebElement mobileInput;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='CONTINUE']") WebElement continueButton;
    @FindBy(how = How.XPATH, using = "//button[normalize-space()='Verify']") WebElement verifyButton;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Please enter a valid Mobile number')]") WebElement errorMessage;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Existing User? Log in']") WebElement existingUser;
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Terms of Use']") WebElement termAndUse;
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Privacy Policy']") WebElement privacyPolicy;
    @FindBy(how = How.XPATH, using = "//a[@class='QqFHMw twnTnD OD+dVw']") WebElement login;


    private WebDriver driver;

 public RegisterPage (WebDriver driver){
     this.driver= driver;
     PageFactory.initElements(driver, this);
 }

    public void enterMobileNumber(String num){
            action.type(mobileInput, num);
    }

    public void clickExistingUser(){
        action.click1(existingUser, "ExistingUser");
    }


    public boolean check(){
        return action.isDisplayed(driver, continueButton);
    }


    public void clickContinue(){
       action.JSClick(driver,continueButton);
    }
    public void clickPolicyOption(){
        action.click(driver, privacyPolicy);
    }

    public String clickTermsOption(){
        action.click1(termAndUse, "term");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.getCurrentUrl();
    }

    public boolean isVerifyButtonDisplayed(){
     return  action.isDisplayed(driver, verifyButton);
    }

    public  void clickVerifyButton(){
       if (isVerifyButtonDisplayed()){
           action.click(driver, verifyButton);
       }
    }

    public boolean isErrorMessage(){
     return   action.isDisplayed(driver, errorMessage);
    }
}

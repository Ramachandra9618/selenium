    package com.ecommerce.pageObjects;

    import com.ecommerce.actiondriver.Action;
    import com.ecommerce.base.BaseClass;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.How;
    import org.openqa.selenium.support.PageFactory;

    public class LoginPage extends BaseClass {

        private WebDriver driver;
        public LoginPage(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }
        Action action = new Action();

        @FindBy(how = How.XPATH, using = "//input[@class='r4vIwl BV+Dqf']") WebElement mobileInput;
        @FindBy(how = How.XPATH, using = "//button[@class='QqFHMw twnTnD _7Pd1Fp']") WebElement requestOTP;
        @FindBy(how = How.XPATH, using = "//button[normalize-space()='Verify']") WebElement verifyButton;
        @FindBy(how = How.XPATH, using = "//a[normalize-space()='Terms of Use']") WebElement terms;
        @FindBy(how = How.XPATH, using = "//a[@class='azBkHf']") WebElement register;
        @FindBy(how = How.XPATH, using = "//button[@class='QqFHMw twnTnD _7Pd1Fp']") WebElement continueButton;
//        @FindBy(how = How.XPATH, using = "//button[normalize-space()='Verify']") WebElement verifyButton;
        @FindBy(how = How.XPATH, using = "//span[contains(text(),'Please enter a valid Mobile number')]") WebElement errorMessage;

        public boolean enterMobileNumber(String num){
           return action.type(mobileInput, num);
        }

        public void clickSendOTP(){
             action.click(driver, requestOTP);
        }

        public void clickRegister(){
            action.click(driver, register);
        }

        public String clickContinue(){
            action.click(driver, continueButton);
            return driver.getCurrentUrl();
        }

        public String clickTerm(){
            action.click(driver, terms);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return driver.getCurrentUrl();
        }
        public boolean isVerifyButtonDisplayed() {
            return action.isDisplayed(driver, verifyButton);
        }

        public boolean isErrorMessage(){
            return   action.isDisplayed(driver, errorMessage);
        }


        public void clickVerifyButton() {
            if (isVerifyButtonDisplayed()) {
                action.click(driver, verifyButton);
            }
        }
    }

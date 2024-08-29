package com.ecommerce.testcases;

import com.ecommerce.base.BaseClass;
import com.ecommerce.pageObjects.LandingPage;
import com.ecommerce.pageObjects.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("LoginPageTests")
public class LoginPageTest extends BaseClass {

    LandingPage landingPage;
    LoginPage loginPage;

    @ParameterizedTest
    @Tag("FunctionalTest")
    @DisplayName("Test Sending OTP with Valid Mobile Number")
    @ValueSource(strings = {"9618395570"})
    public void testSendOTP(String num) {
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        landingPage.clickLogin();
        loginPage.enterMobileNumber(num);
        loginPage.clickSendOTP();
        assertTrue(loginPage.isVerifyButtonDisplayed());
    }


    @Test
    @Tag("RegressionTest")
    @DisplayName("Test Terms of Use Link on Login Page")
    public void testOnTerm() {
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        landingPage.clickLogin();
        String url = loginPage.clickTerm();
        Assertions.assertEquals("https://www.flipkart.com/account/login?ret=/", url);
    }


    @ParameterizedTest
    @Tag("FunctionalTest")
    @DisplayName("Test Registration Flow with Multiple Mobile Numbers")
    @ValueSource(strings = {"9618395570", "589659", "9618395572"})
    public void testRegister(String num) {
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        landingPage.clickLogin();
        loginPage.clickRegister();
        loginPage.enterMobileNumber(num);
        String url = loginPage.clickContinue();
        if (loginPage.isVerifyButtonDisplayed()) {
            loginPage.clickVerifyButton();
            assertTrue(loginPage.isVerifyButtonDisplayed());
        } else if (url.equals("https://www.flipkart.com/account/login?signup=true")) {
            loginPage.clickSendOTP();
            assertEquals(url, "https://www.flipkart.com/account/login?signup=true");
        } else {
            assertTrue(loginPage.isErrorMessage());
        }
    }
}

package com.ecommerce.testcases;

import com.ecommerce.base.BaseClass;
import com.ecommerce.base.GridSetUp;
import com.ecommerce.pageObjects.LandingPage;
import com.ecommerce.pageObjects.RegisterPage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Tag("RegisterPageTests")
public class RegisterPageTest extends BaseClass {
    RegisterPage registerPage;
    LandingPage landingPage;

//    @Test
//    @Tag("SmokeTest")
//    @DisplayName("Test Existing User Click")
//    public void testExistingClick() {
//        landingPage = new LandingPage(driver);
//        registerPage = new RegisterPage(driver);
//        landingPage.mouseOn();
//        registerPage.clickExistingUser();
//    }

    @ParameterizedTest
    @Tag("FunctionalTest")
    @DisplayName("Test Register with Valid and Invalid Mobile Numbers")
    @ValueSource(strings = {"9618395573", "582926"})
    public void testRegister(String num) {
        registerPage = new RegisterPage(driver);
        landingPage = new LandingPage(driver);
        landingPage.mouseOn();
        landingPage.clickRegister();
        registerPage.enterMobileNumber(num);
        registerPage.clickContinue();
        if (registerPage.isVerifyButtonDisplayed()) {
            registerPage.clickVerifyButton();
            assertTrue(registerPage.isVerifyButtonDisplayed());
        } else {
            assertTrue(registerPage.isErrorMessage());
        }
    }

//    @Test
//    @Tag("RegressionTest")
//    @DisplayName("Test Terms of Use Link")
//    public void testTermsAndUse() {
//        registerPage = new RegisterPage(driver);
//        landingPage = new LandingPage(driver);
//        landingPage.mouseOn();
//        String url = registerPage.clickTermsOption();
//        String expected_url = "https://www.flipkart.com/pages/terms";
//        assertEquals(url, expected_url);
//    }
//
//    @Test
//    @Tag("RegressionTest")
//    @DisplayName("Test Privacy Policy Link")
//    public void testPolicy() {
//        registerPage = new RegisterPage(driver);
//        landingPage = new LandingPage(driver);
//        landingPage.mouseOn();
//        registerPage.clickPolicyOption();
//    }
}

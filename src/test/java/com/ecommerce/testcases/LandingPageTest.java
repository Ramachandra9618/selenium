package com.ecommerce.testcases;

import com.ecommerce.base.BaseClass;
import com.ecommerce.pageObjects.LandingPage;
import com.ecommerce.utitlity.ExcelUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("LandingPageTests")
public class LandingPageTest extends BaseClass {
    LandingPage page;

    public static Stream<Arguments> productDataProvider() {
        String filePath = "/home/chandra/Documents/Ecomerace-selenium/src/test/resources/products.xlsx";
        String sheetName = "ProductNames";
        List<Map> excelData = null;
        try {
            excelData = ExcelUtility.loadExcelData(filePath, sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return excelData.stream().map(Arguments::of);
    }

    @Test
    @Tag("UI")
    @DisplayName("Verify that the logo is displayed on the landing page")
    public void logoCheck() {
        page = new LandingPage(driver);
        assertTrue(page.isLogo());
    }

    @Test
    @Tag("UI")
    @DisplayName("Check if My Account is accessible after login")
    public void testMyAccount() {
        page = new LandingPage(driver);
        assertNotNull(page.isLogin(), "is their ");
    }

    @Test
    @Tag("FunctionalTest")
    @DisplayName("Test registration flow on the landing page")
    public void testRegister() {
        page = new LandingPage(driver);
        String register = page.clickRegister();
        System.out.println(register);
        assertNotNull(register);
    }

    @ParameterizedTest
    @Tag("SearchTest")
    @DisplayName("Verify search functionality with various inputs")
    @MethodSource("productDataProvider")
    public void test(Map values) {

        String key = values.get("Products").toString();
        page = new LandingPage(driver);
        String url = page.enterSerch(key);
        System.out.println(url);
        assertTrue(driver.getCurrentUrl().contains(key));

    }


    @Test
    @Tag("UI")
    @DisplayName("Test mouse hover functionality and navigate to registration")
    public void mouse() {
        page = new LandingPage(driver);
        page.mouseOn();
        page.clickRegister();
    }
}

package com.ecommerce.testcases;

import com.ecommerce.base.BaseClass;
import com.ecommerce.pageObjects.ProductPage;
import com.ecommerce.utitlity.ActionUtility;
import com.ecommerce.utitlity.ExcelUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class EndtoEnd extends BaseClass {

    public static Stream<Arguments> productDataProvider() {
        String filePath = "/home/chandra/Documents/Ecomerace-selenium/src/test/resources/products.xlsx";
        String sheetName = "Categories";
        List<Map> excelData = null;
        try {
            excelData = ExcelUtility.loadExcelData(filePath, sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return excelData.stream().map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("productDataProvider")
    public void endToEndTest(Map values) throws InterruptedException, AWTException {
       String category = values.get("Category").toString();
       String subCategory = values.get("SubCategory").toString();
       String type = values.get("Types").toString();
        System.out.println(category+subCategory+type);
        ActionUtility actionUtility = new ActionUtility(driver);
        actionUtility.mouseOnCategory(category);
        actionUtility.mouseOnSubCategory(subCategory);
        actionUtility.mouseClickOnType(type);
        ProductPage productPage = new ProductPage(driver);
        productPage.clickOnfirstProduct();
        Thread.sleep(2000);
        actionUtility.handleTab();
        if (productPage.isAddCart()){
            productPage.clickAddCart();
        Thread.sleep(2000);
            System.out.println(driver.getCurrentUrl());
            Assertions.assertTrue(driver.getCurrentUrl().contains("viewcart"));
            actionUtility.screenShot(type);
        }
    }
}

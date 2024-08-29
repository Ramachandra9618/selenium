package com.ecommerce.testcases;

import com.ecommerce.base.BaseClass;
import com.ecommerce.pageObjects.LandingPage;
import com.ecommerce.pageObjects.TravelPage;
import com.ecommerce.utitlity.ExcelUtility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TravelPageTest extends BaseClass {

    public static Stream<Arguments> dataProvider() {
        String filePath = "/home/chandra/Documents/Ecomerace-selenium/src/test/resources/products.xlsx";
        String sheetName = "Travel";
        List<Map> excelData = null;
        try {
            excelData = ExcelUtility.loadExcelData(filePath, sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return excelData.stream().map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void datePicker(Map values) throws InterruptedException {

        String fromLocation =  values.get("Location").toString();
        String toLocation = values.get("toLocation").toString();
        String month = values.get("month").toString();
        String year = values.get("year").toString();
        String day = values.get("day").toString();


        System.out.println(month+  year+ day );
        LandingPage landingPage = new LandingPage(driver);
        TravelPage travelPage = new TravelPage(driver);
        landingPage.clickOnFlight();
        Thread.sleep(5000);
        travelPage.enterFromInput(fromLocation);
        Thread.sleep(5000);
        travelPage.selectFirstOne(fromLocation);
        Thread.sleep(4000);
        travelPage.enterToInput(toLocation);
        travelPage.selectFirstOne(toLocation);
        Thread.sleep(2000);
        travelPage.clickOnDate();
        travelPage.datePicker(month, year, day);
        travelPage.clickDone();
        travelPage.clickonSearch();
    }

}

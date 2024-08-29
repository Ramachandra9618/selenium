package com.ecommerce.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.FileInputStream;
import java.io.IOException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class BaseClass {

    protected static ExtentReports extentReports;
    protected static ExtentSparkReporter sparkReporter;
    public static WebDriver driver;
    protected ExtentTest test;
    protected Properties prop;



    @BeforeEach
    void setUp(TestInfo testInfo) {
        // Load configuration properties
        prop = new Properties();
        try (FileInputStream ip = new FileInputStream("/home/chandra/Documents/Ecomerace-selenium/Configaration/config.properties")) {
            prop.load(ip);
        } catch (IOException e) {
            throw new RuntimeException("Error loading configuration file", e);
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String timestamp = LocalDateTime.now().format(formatter);
            String reportFileName = String.format("testReport_%s.html", timestamp);
            extentReports = new ExtentReports();
            sparkReporter = new ExtentSparkReporter("testReports/" + reportFileName);
            extentReports.attachReporter(sparkReporter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create a new ExtentTest for each test method
        test = extentReports.createTest(testInfo.getDisplayName(), "Test case: " + testInfo.getTestMethod().orElseThrow().getName());


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.flipkart.com");
    }


    @AfterEach
    void tearDown() {
        // Close the WebDriver
        if (driver != null) {
//            driver.quit();
        }
        extentReports.flush();
    }

}

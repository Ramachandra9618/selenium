package com.ecommerce.base;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
import com.ecommerce.testcases.Browsers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

@ExtendWith(Browsers.class)
public class GridSetUp {

    protected static ExtentReports extentReports;
    protected static ExtentSparkReporter sparkReporter;
    protected WebDriver driver;
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
            extentReports = new ExtentReports();
            sparkReporter = new ExtentSparkReporter("src/test/resources/testReports");
            extentReports.attachReporter(sparkReporter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create a new ExtentTest for each test method
        test = extentReports.createTest(testInfo.getDisplayName(), "Test case: " + testInfo.getTestMethod().orElseThrow().getName());

        // Initialize WebDriver for Selenium Grid
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.ANY);

        try {
            URL gridUrl = new URL("http://localhost:4444/wd/hub");
            driver = new RemoteWebDriver(gridUrl, capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Malformed URL for Selenium Grid", e);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Open the URL from properties file if available
        driver.get( "https://www.flipkart.com");
    }

    @AfterEach
    void tearDown() {
        // Close the WebDriver
        if (driver != null) {
            driver.quit();
        }

        // Flush and close ExtentReports
        extentReports.flush();
    }
}


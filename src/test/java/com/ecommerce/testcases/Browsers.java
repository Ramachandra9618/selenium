package com.ecommerce.testcases;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Browsers implements ParameterResolver {

    private static List<String> browsers;
    private static int browserIndex = 0;

    static {
        Properties prop = new Properties();
        try (FileInputStream ip = new FileInputStream("/home/chandra/Documents/Ecomerace-selenium/Configaration/config.properties")) {
            prop.load(ip);
            String browserConfig = prop.getProperty("browsers");
            browsers = Arrays.asList(browserConfig.split(","));
        } catch (IOException e) {
            throw new RuntimeException("Error loading configuration file", e);
        }
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        // Check if the parameter is of type String and is annotated with @Parameter
        return parameterContext.getParameter().getType().equals(String.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        // Provide the browser value from the list
        String browser = browsers.get(browserIndex % browsers.size());
        browserIndex++;
        return browser;
    }
}


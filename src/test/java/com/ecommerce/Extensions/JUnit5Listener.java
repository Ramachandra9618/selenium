package com.ecommerce.Extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import com.aventstack.extentreports.ExtentTest;

import java.util.Optional;

public class JUnit5Listener implements TestWatcher {

    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        ExtentTest extentTest = getTest();
        if (extentTest != null) {
            extentTest.pass("Test Passed: " + context.getDisplayName());
        }
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        ExtentTest extentTest = getTest();
        if (extentTest != null) {
            extentTest.fail("Test Failed: " + context.getDisplayName() + ". Reason: " + cause.getMessage());
        }
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        ExtentTest extentTest = getTest();
        if (extentTest != null) {
            extentTest.skip("Test Disabled: " + context.getDisplayName() + ". Reason: " + reason.orElse("No reason provided"));
        }
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        ExtentTest extentTest = getTest();
        if (extentTest != null) {
            extentTest.warning("Test Aborted: " + context.getDisplayName() + ". Reason: " + cause.getMessage());
        }
    }
}

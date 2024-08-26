package com.ecommerce.testcases;

import com.ecommerce.base.BaseClass;
import com.ecommerce.base.GridSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleTest extends GridSetUp {

    @Test
    void verifyTitle() {
        String title = driver.getCurrentUrl();
        System.out.println(title);
        Assertions.assertTrue( title.contains("flipkart"));
        test.pass("Title verified successfully");
    }
}

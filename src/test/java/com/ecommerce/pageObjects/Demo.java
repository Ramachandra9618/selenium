package com.ecommerce.pageObjects;

import com.ecommerce.Extensions.JUnit5Listener;
import com.ecommerce.actiondriver.Action;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

@ExtendWith(JUnit5Listener.class)
public class Demo extends com.ecommerce.base.BaseClass {
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Mobiles']")
    WebElement fashion;

    @BeforeEach
    public void setUpPage() {
        PageFactory.initElements(driver, this);
    }

   @Test
    public void clickFashion() {
       Action action = new Action();
       System.out.println(fashion);
       action.click(driver, fashion );
    }
}

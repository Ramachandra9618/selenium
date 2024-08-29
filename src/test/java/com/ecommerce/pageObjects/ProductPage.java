package com.ecommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "realme P1 Pro 5G (Parrot Blue, 256 GB)") WebElement link;
    @FindBy(how = How.XPATH, using = "//div[@class ='gqcSqV YGE0gZ']") WebElement firstProduct;
    @FindBy(how = How.CSS, using = ".In9uk2") WebElement addCart;

    public void clickOnLink() {
        link.click();
    }
    public void clickOnfirstProduct(){
        firstProduct.click();
    }

    public void clickAddCart() {
        addCart.click();
    }

    public boolean isAddCart() {
        return addCart.isDisplayed();
    }
}


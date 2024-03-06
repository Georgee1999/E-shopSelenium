package com.example.eshopselenium.pageObjects.pageObjectModel;

import com.example.eshopselenium.pageObjects.abstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue extends AbstractComponents {

    WebDriver driver;


    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public String getUrl(){
       return driver.getCurrentUrl();
    }

}

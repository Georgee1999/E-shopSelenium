package com.example.eshopselenium.pageObjectModel;

import com.example.eshopselenium.abstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends AbstractComponents {
    WebDriver driver;
    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(tagName = "h1")
    WebElement confirmMessage;
    public String getConfirmationMessage(){
        return confirmMessage.getText();
    }
}

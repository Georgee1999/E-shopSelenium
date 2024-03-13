package com.example.eshopselenium.pageObjects.pageObjectModel;

import com.example.eshopselenium.pageObjects.abstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComponents {

WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='cartSection']/h3")
    WebElement tittleOfProduct;
    @FindBy(xpath = "//li[@class='totalRow']/button")
    WebElement checkoutButton;

    public String getTittleOfProduct(){
       return tittleOfProduct.getText();
    }

    public CheckoutPage goToCheckout(){
        checkoutButton.click();
        CheckoutPage checkoutPage = new CheckoutPage(driver,new Actions(driver));
        return checkoutPage;
    }
}

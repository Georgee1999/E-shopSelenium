package com.example.eshopselenium.pageObjects.pageObjectModel;

import com.example.eshopselenium.pageObjects.abstractComponents.AbstractComponents;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class ProductCatalogue extends AbstractComponents {

    WebDriver driver;

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }


    @FindBy(id = "res")
    WebElement tittleOfCount;

    @FindBy(className = "mb-3")
    List<WebElement> products;
    @FindBy(css = "div[class='py-2 border-bottom ml-3'] input[placeholder='search']")
    WebElement searchInput;
    @FindBy(tagName = "h5")
    WebElement tittleOfProducts;

    public Integer getProductsCount() {
        return products.size();
    }

    public String tittleOfProductsCount() {
        return tittleOfCount.getText();
    }

    public String searchProduct(String nameOfProduct) {
        Actions actions = new Actions(driver);
        String input = nameOfProduct.toUpperCase();
        searchInput.sendKeys(input);
        actions.keyDown(Keys.ENTER).build().perform();
        return tittleOfProducts.getText();
    }


}

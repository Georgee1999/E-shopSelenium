package com.example.eshopselenium.pageObjects.pageObjectModel;

import com.example.eshopselenium.pageObjects.abstractComponents.AbstractComponents;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class ProductCatalogue extends AbstractComponents {

    WebDriver driver;
    Actions actions;

    public ProductCatalogue(WebDriver driver,Actions actions) {
        super(driver);
        this.driver = driver;
        this.actions = actions;
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

    // Price Range
    @FindBy(css = "div[class='text-muted']")
    List<WebElement> priceOfProducts;
    @FindBy(css = "div[class='col-md-6'] input[placeholder='Min Price']")
    WebElement inputPriceMin;
    @FindBy(css = "div[class='py-2 border-bottom ml-3'] input[placeholder='Max Price']")
    WebElement inputPriceMax;

    public Integer getProductsCount() {
        return products.size();
    }

    public String tittleOfProductsCount() {
        return tittleOfCount.getText();
    }

    public String searchProduct(String nameOfProduct) {
        //Actions actions = new Actions(driver);
        String input = nameOfProduct.toUpperCase();
        searchInput.sendKeys(input);
        actions.keyDown(Keys.ENTER).build().perform();
        return tittleOfProducts.getText();
    }


    public List<Integer> priceOfProducts() {
        return priceOfProducts.stream()
                //flatMap, který "zrovná" strukturu z Stream<String[]> na Stream<String>
                .flatMap(e -> Arrays.stream(e.getText().split(" ")))
                .filter(e -> !e.contains("$"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void insertPrice(String min, String max) throws InterruptedException {
        inputPriceMin.sendKeys(min);
        inputPriceMax.sendKeys(max);
        actions.keyDown(Keys.ENTER).build().perform();
        Thread.sleep(1000);
    }


}

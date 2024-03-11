package com.example.eshopselenium.tests.productCatalogue;

import com.example.eshopselenium.pageObjects.pageObjectModel.ProductCatalogue;
import com.example.eshopselenium.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FunctionalTests extends BaseTest {


    @Test(groups = {"Functional"})
    public void searchProduct() {
        ProductCatalogue productCatalogue = landingPage.loginApplication("frank0@gmail.com", "Georgesmith1");
        String tittle = productCatalogue.searchProduct("ZARA COAT 3");
        Assert.assertEquals(tittle, "ZARA COAT 3");
    }

    @Test(groups = {"Functional"})
    public void verifyPriceRange() throws InterruptedException {
        ProductCatalogue productCatalogue = landingPage.loginApplication("frank0@gmail.com", "Georgesmith1");
        productCatalogue.insertPrice("31000", "32000");
        List<Integer> prices = productCatalogue.priceOfProducts();
        Assert.assertEquals(prices.size(),2);
    }

}

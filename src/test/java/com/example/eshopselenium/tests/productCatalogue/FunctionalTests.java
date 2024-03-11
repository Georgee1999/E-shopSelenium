package com.example.eshopselenium.tests.productCatalogue;

import com.example.eshopselenium.pageObjects.pageObjectModel.ProductCatalogue;
import com.example.eshopselenium.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FunctionalTests extends BaseTest {


    @Test(groups = {"Functional"})
    public void searchProduct() {
        ProductCatalogue productCatalogue = landingPage.loginApplication("frank0@gmail.com","Georgesmith1");
        String tittle = productCatalogue.searchProduct("ZARA COAT 3");
        Assert.assertEquals(tittle,"ZARA COAT 3");
    }
}

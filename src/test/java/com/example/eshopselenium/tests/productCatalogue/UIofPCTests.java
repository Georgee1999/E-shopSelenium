package com.example.eshopselenium.tests.productCatalogue;

import com.example.eshopselenium.pageObjects.pageObjectModel.ProductCatalogue;
import com.example.eshopselenium.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UIofPCTests extends BaseTest {


    @Test(groups = {"UI"})
    public void validCountOfProduct(){
        ProductCatalogue productCatalogue = landingPage.loginApplication("frank0@gmail.com","Georgesmith1");
        String tittleOfProductsCount = productCatalogue.tittleOfProductsCount();
        String count = tittleOfProductsCount.split(" ")[1];
        Integer numberFromCount = Integer.parseInt(count);
        Integer number = productCatalogue.getProductsCount();
        Assert.assertEquals(numberFromCount,number);
    }


}

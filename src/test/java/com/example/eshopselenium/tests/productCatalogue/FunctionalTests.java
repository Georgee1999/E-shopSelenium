package com.example.eshopselenium.tests.productCatalogue;

import com.example.eshopselenium.pageObjects.pageObjectModel.CartPage;
import com.example.eshopselenium.pageObjects.pageObjectModel.CheckoutPage;
import com.example.eshopselenium.pageObjects.pageObjectModel.ConfirmationPage;
import com.example.eshopselenium.pageObjects.pageObjectModel.ProductCatalogue;
import com.example.eshopselenium.testComponents.BaseTest;
import com.example.eshopselenium.testComponents.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
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

    @Test(dataProvider = "getData", groups = {"Functional"})
    public void addProductToCart(HashMap<String ,String> input) throws InterruptedException {

        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
        productCatalogue.addToCard(input.get("product"));
        CartPage cartPage = productCatalogue.goToCartPage();
        String url = cartPage.getUrl();
        Assert.assertEquals(url,"https://rahulshettyacademy.com/client/dashboard/cart");
        Assert.assertEquals(cartPage.getTittleOfProduct(),input.get("product"));
    }

    @Test(dataProvider = "getData", groups = {"Functional","SubmitOrder"},retryAnalyzer = Retry.class)
    public void submitOrder(HashMap<String ,String> input) throws InterruptedException {
        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
        productCatalogue.addToCard(input.get("product"));
        CartPage cartPage = productCatalogue.goToCartPage();
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("cz");
        ConfirmationPage confirmationPage = checkoutPage.sumbitOrder();
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }






    @Test(groups = {"Functional"})
    public void logOut(){
        ProductCatalogue productCatalogue = landingPage.loginApplication("frank0@gmail.com", "Georgesmith1");
        productCatalogue.logOut();
        String url = productCatalogue.getUrl();
        Assert.assertEquals(url,"https://rahulshettyacademy.com/client/auth/login");
    }



}

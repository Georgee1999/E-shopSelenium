package com.example.eshopselenium.tests.landingPage;

import com.example.eshopselenium.pageObjectModel.ProductCatalogue;
import com.example.eshopselenium.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LoginTests extends BaseTest {

    @Test(dataProvider = "getData", groups = {"SuccessLogin"})
    public void successLogin(HashMap<String, String> input) {
        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
        Assert.assertEquals(productCatalogue.getUrl(), "https://rahulshettyacademy.com/client/dashboard/dash");
        // New Comments added
    }
    @Test(dataProvider = "getInvalidData", groups = {"InvalidLogin"})
    public void invalidLogin(HashMap<String,String> input){
        String errorPopup = landingPage.invalidLogin(input.get("email"),input.get("password"));
        Assert.assertEquals(errorPopup, "Incorrect email or password.");

    }

    @Test(dataProvider = "getData", groups = {"InvalidLogin","InvalidPassword"})
    public void emptyPassword(HashMap<String, String> input) {
        String emptyPassword = landingPage.emptyPassword(input.get("email"));
        Assert.assertEquals(emptyPassword, "*Password is required");
    }

    @Test(dataProvider = "getData", groups = {"InvalidLogin","InvalidPassword"})
    public void invalidPassword(HashMap<String, String> input) {
        String errorPopup = landingPage.invalidPassword(input.get("email"), "11jhsnfh");
        Assert.assertEquals(errorPopup, "Incorrect email or password.");
    }

    @Test(dataProvider = "getData", groups = {"InvalidLogin","InvalidEmail"})
    public void emptyEmail(HashMap<String, String> input) {
        String emptyPassword = landingPage.emptyEmail(input.get("password"));
        Assert.assertEquals(emptyPassword, "*Email is required");
    }

    @Test(dataProvider = "getData", groups = {"InvalidLogin","InvalidEmail"})
    public void invalidEmail(HashMap<String, String> input) {
        String errorPopup = landingPage.invalidEmail("karel123@gmail.com", input.get("password"));
        Assert.assertEquals(errorPopup, "Incorrect email or password.");
    }






}

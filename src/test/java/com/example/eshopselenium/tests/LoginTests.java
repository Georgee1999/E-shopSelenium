package com.example.eshopselenium.tests;

import com.example.eshopselenium.pageObjects.pageObjectModel.ProductCatalogue;
import com.example.eshopselenium.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginTests extends BaseTest {

    @Test(dataProvider = "getData", groups = {"SuccessLogin"})
    public void login(HashMap<String ,String > input) {
        ProductCatalogue productCatalogue = landingPage.loginAplication(input.get("email"),input.get("password"));
        Assert.assertEquals(productCatalogue.getUrl(),"https://rahulshettyacademy.com/client/dashboard/dash");
    }







    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\com\\example\\eshopselenium\\data\\LoginData.json");
        return new Object[][]{
                {data.get(0)},
                {data.get(1)}
        };
    }
}

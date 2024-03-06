package com.example.eshopselenium.tests;

import com.example.eshopselenium.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UITestOfLandingPage extends BaseTest {


    @Test
    public void visibleTextOfElements(){
        Assert.assertEquals(landingPage.getTextOfLoginTittle(),"Log in");
        Assert.assertEquals(landingPage.getTextOfLoginButton(),"Login");
        Assert.assertTrue(landingPage.isEnable());
    }


}

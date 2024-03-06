package com.example.eshopselenium.tests;

import com.example.eshopselenium.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UITestOfLandingPage extends BaseTest {


    @Test
    public void visibleTextOfElements(){
        Assert.assertEquals(landingPage.getTextOfLoginTittle(),"Log in");
        Assert.assertEquals(landingPage.getTextOfLoginButton(),"Login");
        Assert.assertEquals(landingPage.getTextOfFieldForEmail(),"email@example.com");
        Assert.assertEquals(landingPage.getTextOfFieldForPassword(),"enter your passsword");
        Assert.assertEquals(landingPage.getTextOfForgotPassword(),"Forgot password?");
    }

    @Test
    public void areElementsEnabled(){
        Assert.assertTrue(landingPage.isEnable());
    }


}

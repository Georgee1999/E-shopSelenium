package com.example.eshopselenium.tests;

import com.example.eshopselenium.testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UITestOfLPTest extends BaseTest {


    @Test
    public void visibleTextOfElements() throws InterruptedException {
        Assert.assertEquals(landingPage.getTextOfLoginTittle(),"Log in");
        Assert.assertEquals(landingPage.getTextOfLoginButton(),"Login");
        Assert.assertEquals(landingPage.getTextOfFieldForEmail(),"email@example.com");
        Assert.assertEquals(landingPage.getTextOfFieldForPassword(),"enter your passsword");
        Assert.assertEquals(landingPage.getTextOfForgotPassword(),"Forgot password?");
        Assert.assertEquals(landingPage.getRegisterLinkText(),"Don't have an account? Register here");
        Assert.assertEquals(landingPage.hoverButton(),"rgba(253, 36, 45, 1)");

    }

    @Test
    public void areElementsEnabled(){
        Assert.assertTrue(landingPage.isEnable());
    }


}

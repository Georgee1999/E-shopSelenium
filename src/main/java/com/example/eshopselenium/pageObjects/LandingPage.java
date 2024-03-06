package com.example.eshopselenium.pageObjects;

import com.example.eshopselenium.pageObjects.abstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class LandingPage extends AbstractComponents {

    WebDriver driver;


    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client");
    }

    // Elements
    @FindBy(css = "h1[class='login-title']")
    WebElement loginTitle;

    @FindBy(css = "input[id='login']")
    WebElement loginButton;

    @FindBy(css = "a[class='btn1']")
    WebElement registerButton;

    @FindBy(id = "userEmail")
    WebElement fieldForEmail;

    @FindBy(id = "userPassword")
    WebElement fieldForPassword;

    @FindBy(css = "a[class='forgot-password-link']")
    WebElement forgotPassword;

    List<WebElement> enableElements;


    public String getTextOfLoginTittle() {
        return loginTitle.getText();
    }

    public String getTextOfForgotPassword() {
        return forgotPassword.getText();
    }

    public String getTextOfLoginButton() {
        return loginButton.getAttribute("value");
    }

    public Boolean isEnable() {
        enableElements = Arrays.asList(loginButton, registerButton, forgotPassword, fieldForEmail, fieldForPassword);
        return enableElements.stream().allMatch(WebElement::isEnabled);
    }

    public String getTextOfFieldForEmail() {
        return fieldForEmail.getAttribute("placeholder");
    }

    public String getTextOfFieldForPassword() {
        return fieldForPassword.getAttribute("placeholder");
    }


}

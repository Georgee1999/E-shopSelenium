package com.example.eshopselenium.pageObjectModel;

import com.example.eshopselenium.abstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    @FindBy(className = "login-wrapper-footer-text")
    WebElement registerLink;
    List<WebElement> enableElements;
    @FindBy(xpath = "//div[@class='form-group mb-4'] //div[@class='invalid-feedback']/div")
    WebElement passwordErrorMessage;
    @FindBy(xpath = "//div[text()='*Email is required']")
    WebElement emailErrorMessage;


    //div[aria-label='Incorrect email or password.']
    @FindBy(css = "div[aria-label='Incorrect email or password.']")
    WebElement errorPopup;


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
        enableElements = Arrays.asList(loginButton, registerButton, forgotPassword, fieldForEmail, fieldForPassword, registerLink);
        return enableElements.stream().allMatch(WebElement::isEnabled);
    }

    public String getTextOfFieldForEmail() {
        return fieldForEmail.getAttribute("placeholder");
    }

    public String getTextOfFieldForPassword() {
        return fieldForPassword.getAttribute("placeholder");
    }

    public String getRegisterLinkText() {
        return registerLink.getText();
    }

    public String hoverButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(registerButton).build().perform();
        //Thread.sleep(2000);
        waitForChangeHover(registerButton, "background-color", "rgba(253, 36, 45, 1)");
        return registerButton.getCssValue("background-color");
    }

    public ProductCatalogue loginApplication(String email, String password) {
        fieldForEmail.sendKeys(email);
        fieldForPassword.sendKeys(password);
        loginButton.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver,new Actions(driver));
        waitForElementToAppear("https://rahulshettyacademy.com/client/dashboard/dash");
        return productCatalogue;
    }

    public String invalidLogin(String email, String password) {
        fieldForEmail.sendKeys(email);
        fieldForPassword.sendKeys(password);
        loginButton.click();
        waitForElementIsVisible(errorPopup);
        return errorPopup.getText();
    }

    public String emptyPassword(String email) {
        fieldForEmail.sendKeys(email);
        //fieldForPassword.sendKeys(password);
        loginButton.click();
        return passwordErrorMessage.getText();
    }

    public String invalidPassword(String email, String password) {
        fieldForEmail.sendKeys(email);
        fieldForPassword.sendKeys(password);
        loginButton.click();
        waitForElementIsVisible(errorPopup);
        return errorPopup.getText();
    }

    public String emptyEmail(String password) {
        fieldForPassword.sendKeys(password);
        loginButton.click();
        return emailErrorMessage.getText();
    }

    public String invalidEmail(String email, String password) {
        fieldForEmail.sendKeys(email);
        fieldForPassword.sendKeys(password);
        loginButton.click();
        waitForElementIsVisible(errorPopup);
        return errorPopup.getText();
    }


}

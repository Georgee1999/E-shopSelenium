package com.example.eshopselenium.pageObjects;

import com.example.eshopselenium.pageObjects.abstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.text.StyledEditorKit;
import java.util.List;
import java.util.stream.Collectors;

public class LandingPage extends AbstractComponents {

    WebDriver driver;


    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void goTo(){
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



    public String getTextOfLoginTittle(){
        return loginTitle.getText();
    }
    public String getTextOfLoginButton(){
        return loginButton.getAttribute("value");
    }
    public Boolean isEnable(){
        Boolean match = null;
        if (loginButton.isEnabled() && registerButton.isEnabled()){
             match = true;
        }
        return match;
    }

    public


}

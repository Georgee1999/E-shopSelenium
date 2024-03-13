package com.example.eshopselenium.abstractComponents;

import com.example.eshopselenium.pageObjectModel.CartPage;
import com.example.eshopselenium.pageObjectModel.LandingPage;
import com.example.eshopselenium.pageObjectModel.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents {

    WebDriver driver;

    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void waitForChangeHover(WebElement element,String cssProperty, String expectedValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeToBe(element, cssProperty, expectedValue));
    }

    public void waitForElementToAppear(String url){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains(url));
    }
    public void waitForElementIsVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementToDisappear(WebElement element) throws InterruptedException {
        Thread.sleep(1000);
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public void waitForElementToAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }


    @FindBy(css = "button[routerlink*='cart']")
    WebElement cartHeader;
    public CartPage goToCartPage(){
        cartHeader.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
    @FindBy(css = "button[routerlink='/dashboard/myorders']")
    WebElement orderHeader;
    public OrderPage goToOrderPage(){
        orderHeader.click();
        OrderPage orderPage =new OrderPage(driver);
        return orderPage;
    }

    //button i[class*='fa-sign-out']
    @FindBy(css = "button i[class*='fa-sign-out']")
    WebElement signOutHeader;
    public LandingPage clickToSignOut(){
        signOutHeader.click();
        LandingPage landingPage = new LandingPage(driver);
        return landingPage;
    }



}

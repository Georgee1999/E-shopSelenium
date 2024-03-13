package com.example.eshopselenium.pageObjects.pageObjectModel;

import com.example.eshopselenium.pageObjects.abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponents {

    WebDriver driver;
    Actions actions;

    public CheckoutPage(WebDriver driver, Actions actions) {
        super(driver);
        this.actions = actions;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[placeholder='Select Country']")
    public WebElement country;

    @FindBy(xpath = "(//button[contains(@class,'list-group')])[1]")
    public WebElement selectCountry;

    @FindBy(xpath = "//a[text()='Place Order ']")
    public WebElement submit;

    public By results = By.cssSelector("section[class*='list-group']");

    public void selectCountry(String countryName) {
        actions.sendKeys(country, countryName).build().perform();
        waitForElementToAppear(results);
        selectCountry.click();
    }

    public ConfirmationPage sumbitOrder() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,150)");
        Thread.sleep(1000);
        submit.click();
        return new ConfirmationPage(driver);
    }
}

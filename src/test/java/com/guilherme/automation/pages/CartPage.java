package com.guilherme.automation.pages;

import com.guilherme.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutInformationPage clickCheckout() {
        click(checkoutButton);
        return new CheckoutInformationPage(driver);
    }
}
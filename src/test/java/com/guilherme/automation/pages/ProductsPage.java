package com.guilherme.automation.pages;

import com.guilherme.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By pageTitle = By.cssSelector(".title");
    private final By inventoryList = By.cssSelector(".inventory_list");
    private final By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartLink = By.cssSelector(".shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAt() {
        return driver.getCurrentUrl().contains("/inventory.html")
                && waitVisible(inventoryList).isDisplayed()
                && text(pageTitle).equalsIgnoreCase("Products");
    }

    public ProductsPage addBackpackToCart() {
        click(addBackpackButton);
        return this;
    }

    public CartPage goToCart() {
        click(cartLink);
        return new CartPage(driver);
    }
}
package com.guilherme.automation.pages;

import com.guilherme.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage extends BasePage {

    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutInformationPage fillFirstName(String firstName) {
        type(firstNameInput, firstName);
        return this;
    }

    public CheckoutInformationPage fillLastName(String lastName) {
        type(lastNameInput, lastName);
        return this;
    }

    public CheckoutInformationPage fillPostalCode(String postalCode) {
        type(postalCodeInput, postalCode);
        return this;
    }

    public CheckoutOverviewPage clickContinue() {
        click(continueButton);
        return new CheckoutOverviewPage(driver);
    }
}
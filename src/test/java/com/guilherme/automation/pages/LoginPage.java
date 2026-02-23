package com.guilherme.automation.pages;

import com.guilherme.automation.base.BasePage;
import com.guilherme.automation.utils.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton   = By.id("login-button");
    private final By errorMessage  = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(Config.SAUCE_BASE_URL);
        return this;
    }

    public LoginPage typeUsername(String username) {
        type(usernameInput, username);
        return this;
    }

    public LoginPage typePassword(String password) {
        type(passwordInput, password);
        return this;
    }

    public void clickLogin() {
        click(loginButton);
    }

    public String getErrorMessage() {
        return text(errorMessage);
    }
}
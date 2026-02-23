package com.guilherme.automation.ui;

import com.guilherme.automation.base.BaseTest;
import com.guilherme.automation.pages.LoginPage;
import com.guilherme.automation.pages.ProductsPage;
import com.guilherme.automation.utils.Config;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    void shouldLoginSuccessfully() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.open()
                .typeUsername(Config.SAUCE_USER_STANDARD)
                .typePassword(Config.SAUCE_PASSWORD)
                .clickLogin();

        assertTrue(productsPage.isAt(), "Esperava estar na página de produtos após login válido.");
    }
}
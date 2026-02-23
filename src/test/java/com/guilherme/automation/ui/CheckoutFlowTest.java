package com.guilherme.automation.ui;

import com.guilherme.automation.base.BaseTest;
import com.guilherme.automation.pages.*;
import com.guilherme.automation.utils.Config;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutFlowTest extends BaseTest {

    @Test
    void shouldCompleteCheckoutSuccessfully() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        // Pré-condição (Excel): usuário autenticado
        loginPage.open()
                .typeUsername(Config.SAUCE_USER_STANDARD)
                .typePassword(Config.SAUCE_PASSWORD)
                .clickLogin();

        assertTrue(productsPage.isAt(), "Esperava estar na página de produtos após login.");

        // Fluxo (Excel): adicionar ao carrinho, checkout, preencher dados, finalizar
        CartPage cartPage = productsPage.addBackpackToCart().goToCart();
        CheckoutInformationPage infoPage = cartPage.clickCheckout();

        CheckoutOverviewPage overviewPage = infoPage
                .fillFirstName("Guilherme")
                .fillLastName("Hirata")
                .fillPostalCode("18000")
                .clickContinue();

        CheckoutCompletePage completePage = overviewPage.clickFinish();

        // Critério de aceite (Excel)
        assertEquals("Thank you for your order!", completePage.getSuccessMessage());
    }
}
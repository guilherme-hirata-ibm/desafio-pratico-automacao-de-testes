package com.guilherme.automation.ui;

import com.guilherme.automation.base.BaseTest;
import com.guilherme.automation.pages.LoginPage;
import com.guilherme.automation.utils.Config;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginNegativeTest extends BaseTest {

    @Test
    void shouldShowErrorMessageWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open()
                .typeUsername(Config.SAUCE_USER_STANDARD)
                .typePassword("senha_errada")
                .clickLogin();

        String error = loginPage.getErrorMessage();

        assertTrue(error.toLowerCase().contains("do not match"),
                "Esperava mensagem de erro indicando credenciais inválidas. Mensagem atual: " + error);
    }
}
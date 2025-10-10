package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VerifyLoginModalOpensTest extends BaseTest {

    @Test
    public void verifyLoginModalOpens() {
        HomePage home = new HomePage(driver);
        home.openLogin();
        assertTrue(home.isLoginModalDisplayed(), "Login modal not opened!");
    }
}

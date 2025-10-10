package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VerifySignupModalOpensTest extends BaseTest {

    @Test
    public void verifySignupModalOpens() {
        HomePage home = new HomePage(driver);
        home.openSignup();
        assertTrue(home.isSignupModalDisplayed(), "Signup modal not opened!");
    }
}

package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VerifyHomePageTitleTest extends BaseTest {

    @Test
    public void verifyHomePageTitle() {
        HomePage home = new HomePage(driver);
        assertTrue(home.isOnHomePage(), "Home page did not load / product list not visible");
    }
}

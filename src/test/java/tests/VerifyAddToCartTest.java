package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ProductPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VerifyAddToCartTest extends BaseTest {

    @Test
    public void verifyAddToCart() {
        HomePage home = new HomePage(driver);
        // home.goTo(); // not needed; BaseTest already navigates
        assertTrue(home.isOnHomePage(), "Home page not ready");

        home.clickFirstProduct();

        ProductPage product = new ProductPage(driver);
        assertTrue(product.isOnProductPage(), "Product page not opened!");

        product.addToCart(); // this method waits for and accepts the alert internally
    }
}

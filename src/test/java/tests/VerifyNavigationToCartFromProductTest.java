package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VerifyNavigationToCartFromProductTest extends BaseTest {

    @Test
    public void verifyNavigationToCartFromProduct() {
        HomePage home = new HomePage(driver);
        assertTrue(home.isOnHomePage(), "Home page not ready");

        home.clickFirstProduct();

        ProductPage product = new ProductPage(driver);
        assertTrue(product.isOnProductPage(), "Not on product page");

        product.addToCart(); // accepts alert

        // navigate to cart (HomePage clickCart clicks #cartur)
        home.clickCart();

        CartPage cart = new CartPage(driver);
        assertTrue(cart.isOnCartPage(), "Cart page not opened after adding item");
    }
}

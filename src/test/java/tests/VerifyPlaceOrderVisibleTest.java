package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.*;

public class VerifyPlaceOrderVisibleTest extends BaseTest {

    @Test
    public void verifyPlaceOrderVisible() {
        driver.get("https://www.demoblaze.com/cart.html");
        boolean isVisible = driver.findElement(By.xpath("//button[text()='Place Order']")).isDisplayed();
        assertTrue(isVisible, "Place Order button not visible!");
    }
}

package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class VerifyRemoveItemFromCartTest extends BaseTest {

    @Test
    public void verifyRemoveItemFromCart() throws InterruptedException {
        driver.get("https://www.demoblaze.com/cart.html");

        int initialRows = driver.findElements(By.cssSelector("tr.success")).size();

        if (initialRows > 0) {
            driver.findElement(By.xpath("//a[text()='Delete']")).click();
            Thread.sleep(2000);
            int newRows = driver.findElements(By.cssSelector("tr.success")).size();
            assertTrue(newRows < initialRows, "Item not removed from cart!");
        } else {
            System.out.println("No items in cart to remove. Skipping test.");
        }
    }
}

package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class VerifyCartButtonClickableTest extends BaseTest {

    @Test
    public void verifyCartButtonClickable() {
        driver.get("https://www.demoblaze.com/");
        assertDoesNotThrow(() -> driver.findElement(By.id("cartur")).click(), 
                "Cart button not clickable!");
    }
}

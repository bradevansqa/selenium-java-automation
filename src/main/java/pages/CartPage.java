package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By placeOrderButton = By.xpath("//button[text()='Place Order']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnCartPage() {
        // either check URL or presence of "Place Order" button
        try {
            return isDisplayed(placeOrderButton) || driver.getCurrentUrl().contains("cart.html");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPlaceOrderVisible() {
        return isDisplayed(placeOrderButton);
    }
}

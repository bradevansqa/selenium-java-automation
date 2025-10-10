package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    private By addToCartButton = By.cssSelector("a.btn.btn-success.btn-lg");
    private By productTitle = By.cssSelector(".name");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
            return driver.findElement(productTitle).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            throw new AssertionError("No alert shown after adding to cart!");
        }
    }
}

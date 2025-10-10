package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    private By productLinks = By.cssSelector("a.hrefch");
    private By loginButton = By.id("login2");
    private By signupButton = By.id("signin2");
    private By cartLink = By.id("cartur");

    // Modal locators
    private By loginModal = By.id("logInModal");
    private By signupModal = By.id("signInModal");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        driver.get("https://www.demoblaze.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productLinks));
    }

    public boolean isOnHomePage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(productLinks));
            return driver.findElements(productLinks).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickFirstProduct() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productLinks));
        List<WebElement> list = driver.findElements(productLinks);
        if (list.isEmpty()) {
            throw new RuntimeException("No products found on homepage!");
        }
        list.get(0).click();
    }

    public void clickCart() {
        click(cartLink);
    }

    public void openLogin() {
        click(loginButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginModal));
    }

    public void openSignup() {
        click(signupButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupModal));
    }

    public boolean isLoginModalDisplayed() {
        try {
            return driver.findElement(loginModal).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSignupModalDisplayed() {
        try {
            return driver.findElement(signupModal).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

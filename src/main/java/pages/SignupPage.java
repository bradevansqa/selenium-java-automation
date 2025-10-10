package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BasePage {
    private By signupModal = By.id("signInModal");

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignupModalDisplayed() {
        return isDisplayed(signupModal);
    }
}

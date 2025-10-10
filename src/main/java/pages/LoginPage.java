package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By loginModal = By.id("logInModal");
    private By usernameField = By.id("loginusername");
    private By passwordField = By.id("loginpassword");
    private By loginButton = By.xpath("//button[text()='Log in']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginModalDisplayed() {
        return isDisplayed(loginModal);
    }

    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }
}

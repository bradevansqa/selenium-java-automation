package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends BasePage {

    private By emailField = By.id("recipient-email");
    private By nameField = By.id("recipient-name");
    private By messageField = By.id("message-text");
    private By sendButton = By.xpath("//button[text()='Send message']");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void sendMessage(String email, String name, String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(messageField).sendKeys(message);
        driver.findElement(sendButton).click();
        driver.switchTo().alert().accept();
    }
}

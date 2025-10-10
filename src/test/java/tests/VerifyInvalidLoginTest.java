package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.fail;

public class VerifyInvalidLoginTest extends BaseTest {

    @Test
    public void verifyLoginInvalidUser() {
        driver.get("https://www.demoblaze.com/");
        driver.findElement(By.id("login2")).click();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));

        driver.findElement(By.id("loginusername")).sendKeys("fakeuser");
        driver.findElement(By.id("loginpassword")).sendKeys("wrongpass");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        try {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            fail("No alert shown for invalid login!");
        }
    }
}

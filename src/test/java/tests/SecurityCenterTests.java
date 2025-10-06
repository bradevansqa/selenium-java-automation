package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class SecurityCenterTests {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // for CI (no UI)
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyPageTitle() throws InterruptedException {
        String url = "https://www.bankofamerica.com/security-center/";
        driver.get(url);
        System.out.println("Navigating to: " + url);

        // Wait a bit for the page to load fully
        Thread.sleep(4000);

        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + actualUrl);
        System.out.println("Initial title: " + actualTitle);

        // Retry once if the page didn't load correctly the first time
        if (actualTitle.equals("New Tab") || actualTitle.isEmpty()) {
            System.out.println("Page may not have loaded correctly, retrying...");
            driver.navigate().refresh();
            Thread.sleep(4000);
            actualTitle = driver.getTitle();
            System.out.println("Retried title: " + actualTitle);
        }

        String expectedTitle = "Security Center Overview | Bank of America";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

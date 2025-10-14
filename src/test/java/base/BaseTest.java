package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;

    @BeforeAll
    void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void beforeEach() {
        ChromeOptions options = new ChromeOptions();

        // ✅ Headless mode for CI
        options.addArguments("--headless=new"); // use --headless=new for Chrome >=109
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--remote-allow-origins=*");

        // ✅ unique temp user-data-dir to avoid conflicts
        options.addArguments("--user-data-dir=/tmp/chrome-user-data-" + System.currentTimeMillis());

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // start each test at home page
        driver.get("https://www.demoblaze.com/");
    }

    @AfterEach
    void afterEach() {
        if (driver != null) {
            driver.quit();
        }
    }
}

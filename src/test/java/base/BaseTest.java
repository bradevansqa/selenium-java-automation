package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;

    @BeforeAll
    void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void beforeEach() {
        driver = new ChromeDriver();
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

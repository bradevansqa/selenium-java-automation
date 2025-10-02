package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SecurityCenterTests extends BaseTest {

    @Test
    public void verifyPageTitle() {
        String expectedTitle = "Security Center Overview | Bank of America";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Page title mismatch!");
    }
}

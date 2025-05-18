package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LambdaTestAutomation {
    private WebDriver driver;
    private String username = "your_username";
    private String accessKey = "your_access_key";
    private String gridURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";

    @BeforeClass
    @Parameters({"browser", "version", "platform"})
    public void setUp(String browser, String version, String platform) throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserName", browser);
        options.setCapability("browserVersion", version);

        Map<String, Object> lambdaOptions = new HashMap<>();
        lambdaOptions.put("platformName", platform);
        lambdaOptions.put("build", "LambdaTest Build 1");
        lambdaOptions.put("name", "LambdaTestAutomation");

        options.setCapability("LT:Options", lambdaOptions);

        driver = new RemoteWebDriver(new URL(gridURL), options);
        driver.manage().window().maximize();
    }

    @Test
    public void testLambdaTestScenario() throws InterruptedException {
        driver.get("https://www.lambdatest.com");

        // Explicit wait for all elements to load
        Thread.sleep(5000);

        // Scroll to 'SEE ALL INTEGRATIONS'
        WebElement integrationsButton = driver.findElement(By.xpath("//a[text()='See All Integrations']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", integrationsButton);

        // Click on 'SEE ALL INTEGRATIONS'
        integrationsButton.click();

        // Capture window handles
        Set<String> windowHandles = driver.getWindowHandles();
        Assert.assertEquals(windowHandles.size(), 2, "Expected two windows after clicking the link.");

        // Switch to new window and validate URL
        String parentWindow = driver.getWindowHandle();
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        String expectedUrl = "https://www.lambdatest.com/integrations";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL does not match expected.");

        // Close new window
        driver.close();
        driver.switchTo().window(parentWindow);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

package selenium.testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {
	
	public   WebDriver driver;
	public WebDriver initializeDriver() throws IOException {
	    Properties props = new Properties();
	    FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\selenium\\resources\\GlobalData.properties");
	    props.load(fis);
	    String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : props.getProperty("browser");
	    System.out.println("Browser name: " + browserName);

	    switch (browserName.toLowerCase()) {
	        case "chrome":
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	            break;
	        case "firefox":
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	            break;
	        case "edge":
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	            break;
	        default:
	            throw new IllegalArgumentException("Unsupported browser: " + browserName);
	    }

	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    return driver;
	}
}

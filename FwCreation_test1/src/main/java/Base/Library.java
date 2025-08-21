package Base;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Library extends Abstract {
	
	
public void launchApplication() throws IOException {
	String file_loc = System.getProperty("user.dir")+"\\globalProps.properties";
	Properties props = new Properties();
	
	FileInputStream fis = new FileInputStream(file_loc);
	props.load(fis);
	
	String browserName = props.getProperty("browser");

	switch (browserName) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
	case "edge":
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		break;
	case "safari":
		WebDriverManager.safaridriver().setup();
		driver = new SafariDriver();
		break;

	default:
		throw new IllegalArgumentException("Unsuported browser: " + browserName);
		
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	driver.get("https://demo.opencart.com/"); // load page before adding cookies
    
    
    // Read cookies from file and add to driver
       try (BufferedReader reader = new BufferedReader(new FileReader("cookie.data"))) {
           String line;
           while ((line = reader.readLine()) != null) {
               String[] parts = line.split(";");
               String name = parts[0];
               String value = parts[1];
               String domain = parts[2];
               String path = parts[3];
               String expiry = parts[4];
               boolean isSecure = Boolean.parseBoolean(parts[5]);

               Cookie cookie = new Cookie.Builder(name, value)
                       .domain(domain)
                       .path(path)
                       .isSecure(isSecure)
                       .build();

               driver.manage().addCookie(cookie);
           }
       }
           
           driver.navigate().refresh();
}
}

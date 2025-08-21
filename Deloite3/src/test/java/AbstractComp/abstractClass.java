package AbstractComp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import BaseTest.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class abstractClass extends baseTest {
	WebDriver driver;
	public abstractClass(WebDriver driver) {
		this.driver = driver;
	}
	
public void lounchApplication() throws IOException {
		
		String browser = readProperty("browser");
		String url = readProperty("url");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	
	
}

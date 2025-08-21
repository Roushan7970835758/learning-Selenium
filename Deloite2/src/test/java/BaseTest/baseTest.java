package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;



public class baseTest {
	public static WebDriver driver;
	
	
	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		driver.get("https://www.naukri.com/mnjuser/homepage");
	
	}
}

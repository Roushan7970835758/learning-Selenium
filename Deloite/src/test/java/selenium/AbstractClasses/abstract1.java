package selenium.AbstractClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.BaseTest.baseTest;


public class abstract1 extends baseTest {
	
	public abstract1(WebDriver driver) {
		this.driver = driver;
	}
	public void loanchApplication() throws IOException {
		String Browser = getGlobalProperties("Browser");
		String url = getGlobalProperties("url");
		System.out.println("Browser is "+ Browser);
		WebDriverManager.chromedriver().setup();
		
		
		
	}
  
}

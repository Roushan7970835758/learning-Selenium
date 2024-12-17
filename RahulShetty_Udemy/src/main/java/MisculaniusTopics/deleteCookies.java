package MisculaniusTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class deleteCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		System.out.println(options.getBrowserVersion());
		options.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(options);
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		
		driver.get("https://www.google.com");
		
		

	}

}

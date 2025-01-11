package Selenium.SeleniumRevision;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationWithinTabs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("chromeDriver.exe","C:\\Users\\User\\Downloads\\chrome-win64 (1)\\chrome-win64");
		
		WebDriver driver  = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.google.com");
		driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
		driver.navigate().back();
		driver.navigate().to("https://www.facebook.com");

	}

}

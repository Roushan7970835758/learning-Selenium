import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		
		System.out.println("Process Completed");

	}

}

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.*;

public class seliniumIntro {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
//		WebDriverManager.edgedriver().setup();
		
//		System.setProperty("chromedriver.exe","C:\\Users\\User\\AppData\\Local\\Programs\\Python\\Python312");
        
		
		WebDriver driver = new ChromeDriver();
		  // Automatically resolve and download the appropriate ChromeDriver
        
        
		driver.get("https://rahulshettyacademy.com/");
		
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(title);
		
		
		System.out.println(driver.getPageSource());
//		driver.close();  // close only the main tab opened by selenium
		driver.quit();   // close all the tabs open by selenium
		System.out.println("script completed");
		
		}

}

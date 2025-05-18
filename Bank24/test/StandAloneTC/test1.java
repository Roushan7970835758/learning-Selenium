package StandAloneTC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test1 {
	public static void main(String[] args) {
//		 System.setProperty("chromeDriver.exe","C:\\Users\\User\\Downloads");
		WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://next.privat24.ua/");
			 driver.findElement(By.id("84795647402")).click();
		
		
	}

}

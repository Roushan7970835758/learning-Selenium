package test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test2 {
	@AfterTest
	public void demo3() {
		System.out.println("This will execute last");
	}
	
	@Test
	public void demo1() {
		System.out.println("hey");
		
	}
	@BeforeTest
	public void demo2() {
		System.out.println("This willl execute first");
	}
	
	@Test
	public void temp4() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		System.out.println("opening amazon tab .... ");
	}
	
}
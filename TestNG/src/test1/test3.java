package test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test3 {
	
	
	@Test
//	@Parameters({"URL"});
	public void webLoginCarLoan() {
		System.out.println("webLoginCarLoan");
//		System.out.println(urlName);
		
		// selenium--> driver.get(urlName)
	}
	@Test
	public void temp4() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		System.out.println("opening facebook tab .... ");
	}
	
	@Test(groups={"smoke"})
	public void mobileLoginCarLoan() {
		System.out.println("mobileLoginCarLoan");
	}
	
//	@Parameters({"URL"})
	@Test
	public void loginAPICarLoan() {
		System.out.println("loginAPICarLoan");
	}
}

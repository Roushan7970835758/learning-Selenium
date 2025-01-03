package test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test4 {
	@Test
	public void webLoginHomeLoan() {
		System.out.println("webLoginHomeLoan");
	}
	
	@Test(dependsOnMethods= {"mobileSignInHomeLoan"})
	public void mobileLoginHomeLoan() {
		System.out.println("mobileLoginHomeLoan");
	}
	@Test
	public void mobileSignInHomeLoan() {
		System.out.println("mobile Sign In CarLoan");
	}
	@Test(enabled=false)
	public void mobileSignOutHomeLoan() {
		System.out.println("mobile Sign Out CarLoan");
	}
	
	@Test(dependsOnMethods= {"webLoginHomeLoan"})
	public void loginAPIHomeLoan() {
		System.out.println("loginAPIHomeLoan");
	}
	@Test(timeOut=4000,groups= {"smoke2"})
	public void timeoutTest() {
		System.out.println("test takes too long time....");
	}
	@Test
	public void temp4() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.github.com");
		System.out.println("opening github tab .... ");
	}
}

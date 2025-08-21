package selenium.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import selenium.testComponents.baseTest;
import selenium.testComponents.landingPage;

public class firstTest extends baseTest {
	WebDriver driver;
	public firstTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	@Test
	public void firstTest2() throws IOException {
		landingPage lp = new landingPage(driver);
		lp.launchApplication();
		
		driver.findElement(By.id("usernameField")).sendKeys("rroushan40@gmail.com");
		driver.findElement(By.id("passwordField")).sendKeys("Roushan@123"); // Replace with actual username
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

}

package LoginPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BeforeLogin {
	public static WebDriver driver;
	String email = "rroushan40@gmail.com";
	
	@BeforeMethod(alwaysRun = true)
	public void Login() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();		
		driver.get("https://www.naukri.com/mnjuser/homepage");
		driver.findElement(By.id("login_Layer")).click();
		
		driver.findElement(By.id("usernameField")).sendKeys(email);
		driver.findElement(By.id("passwordField")).sendKeys("Roushan@123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("view-profile-wrapper")));
		
	}
	
	@AfterSuite(alwaysRun = true)
	public void exitBrowser() {
		driver.close();
	}
}

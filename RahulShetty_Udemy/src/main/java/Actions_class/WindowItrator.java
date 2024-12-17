package Actions_class;

import java.awt.Window;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.*;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WindowItrator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		
		
		driver.findElement(By.xpath("//a[contains(text(),\"Free Access \")]")).click();
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		w.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		
		String parentId = it.next();
		String childId = it.next();
		System.out.println("parent id: "+parentId);
		System.out.println("child id: "+childId);
		driver.switchTo().window(childId);
		
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText().split(" ")[4]);
		String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split(" ")[4];
		
		driver.switchTo().window(parentId);
		
		w.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(args);
		
		
		
		
		
		
		
		

	}

}

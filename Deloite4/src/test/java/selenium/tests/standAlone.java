package selenium.tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class standAlone {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	driver.findElement(By.xpath("//button[@title='New Tab']")).click();
	
	String parentWindow = driver.getWindowHandle();
	
	Set<String> allWindows = driver.getWindowHandles();
	Iterator<String> it = allWindows.iterator();
	
	String parnetWindowIT = it.next();
	String childWindowIT = it.next();
	
	System.out.println("Parent Window ID: " + parentWindow);
	
	driver.switchTo().window(childWindowIT);
	
	
	
	
}
}

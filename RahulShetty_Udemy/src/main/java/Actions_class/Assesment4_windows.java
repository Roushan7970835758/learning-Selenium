package Actions_class;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Assesment4_windows {

	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),\"Multiple Windows\")]")).click();
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));

		
		
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()=\"Click Here\"]"))));
		
		driver.findElement(By.xpath("//a[text()=\"Click Here\"]")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		 
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		
		driver.switchTo().window(parentId);	
		
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		
		

	}

}

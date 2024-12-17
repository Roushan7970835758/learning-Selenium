package Dropdown_Practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DateSelection {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String day ="17";
		String month ="06";
		String year ="2027";
//		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[contains(text(),\"Top Deals\")]")).click();
		
		Set<String> window = driver.getWindowHandles();
		
		Iterator<String> it = window.iterator();
		it.next();
		
		driver.switchTo().window(it.next());
		
		
		
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		
		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
		driver.findElements(By.className("react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
		
		driver.findElement(By.xpath("//abbr[text()='" + day +"']")).click();
		
		
		
		
		
		System.out.println("process completed");
		
		
		
		

	}

}

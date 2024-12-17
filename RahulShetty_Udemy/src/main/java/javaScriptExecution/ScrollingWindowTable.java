package javaScriptExecution;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingWindowTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,500)");
		
		int count=0;
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"tableFixHead\"]//td[4]"));
		
		for(int i=0;i<list.size();i++) {
			String temp = list.get(i).getText();
			
			count+=Integer.parseInt(temp);
		}
		System.out.println("the sum of all amount is: " +count);
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=500");
		
		String ans = driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim();
		System.out.println(ans);
		
		Assert.assertEquals(count,Integer.parseInt(ans));
		
		System.out.println("process Completed Successfully !!!");

	}

}

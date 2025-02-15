package funtionalTesting;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addToCartFeature {
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		String temp[] = {"Cucumber","Brocolli","Brinjal","Beetroot","Carrot"};
		
		addItems(driver,temp);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
//		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),\"PROCEED TO CHECKOUT\")]")).click();
		
		driver.findElement(By.xpath("//input[@class=\"promoCode\"]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class=\"promoBtn\"]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),\"Apply\")]")).click();
		
//		Thread.sleep(3000);
		//Explicit wait
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),\\\"Code applied ..!\\\")]")));
		
		
		
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),\"Code applied ..!\")]")).getText());
		
		driver.findElement(By.xpath("//button[contains(text(),\"Place Order\")]")).click();
		
		
		driver.findElement(By.xpath("//select")).click();
		driver.findElement(By.xpath("//option[@value=\"India\"]")).click();
		
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),\"Proceed\")]")).click();
		
		
		
		
		driver.findElement(By.xpath("//button[contains(text(),\"Place Order\")]")).click();
		
		
		
//		Thread.sleep(2000);
	
		
//		driver.findElement(By.xpath("//h4[contains(text(),\"Brocolli - 1 Kg\")]//parent::div//button[text()=\"ADD TO CART\"]")).click();
		
		
		

	}
public static void addItems(WebDriver driver,String[] List) throws InterruptedException {
	List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));
	Thread.sleep(2000);
	List listItems = Arrays.asList(List);
	
	for(int i=0,j=0;i<product.size() && j<= List.length;i++) {
		String name = product.get(i).getText().split(" ")[0];
		System.out.println(name);
		
		
		if(listItems.contains(name)){
			
			driver.findElements(By.xpath("//div[@class=\"product-action\"]/button")).get(i).click();
			j++;
		
			
		}
	}
	}

}

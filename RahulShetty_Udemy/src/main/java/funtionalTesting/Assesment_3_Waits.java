package funtionalTesting;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.*;

public class Assesment_3_Waits {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("input[name=\"username\"]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys("learning");

		driver.findElement(By.xpath("//span[contains(text(),\"User\")]//following::span[@class=\"checkmark\"]"))
				.click();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.xpath("//button[@id=\"okayBtn\"]")).click();
		
		driver.findElement(By.cssSelector("select[class =form-control]")).click();
		driver.findElement(By.cssSelector("option[value=consult]")).click();
		driver.findElement(By.cssSelector("input[type=checkbox]")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//button[contains(text(),\"Add\")]"))));
		List<WebElement> Items = driver.findElements(By.xpath("//button[contains(text(),\"Add\")]"));
		
		int n = Items.size();
		
		for(int i=0;i<n;i++) {
			Items.get(i).click();
		}
		
		driver.findElement(By.xpath("//a[contains(text(),\" Checkout\")]")).click();
		
		
		System.out.println("process completed");

	}

}

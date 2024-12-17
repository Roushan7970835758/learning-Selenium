package Dropdown_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox_Assesment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("checkBoxOption1")).click();
		
		
		
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		driver.findElement(By.id("checkBoxOption1")).click();
		
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//getting the count of no. of checkboxes
		List<WebElement> temp = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
		System.out.println(temp.size());
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("process completed successfully");

	}

}

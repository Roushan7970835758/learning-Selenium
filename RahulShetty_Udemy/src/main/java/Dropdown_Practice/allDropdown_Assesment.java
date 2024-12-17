package Dropdown_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class allDropdown_Assesment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//label[contains(text(),\"Name\")]//following-sibling::input")).sendKeys("Roushan");
		
		driver.findElement(By.xpath("//label[contains(text(),\"Email\")]//following-sibling::input")).sendKeys("rroushan49@gmail.com");
		
		driver.findElement(By.xpath("//label[contains(text(),\"Password\")]//following-sibling::input")).sendKeys("Roushan@123");
		
		driver.findElement(By.xpath("//input[@id=\"exampleCheck1\"]")).click();
		
		driver.findElement(By.xpath("//input[@id=\"exampleFormControlSelect1\"]")).click();
		
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select  select = new Select(dropdown);
		
		select.selectByContainsVisibleText("Male");
		
		driver.findElement(By.id("inlineRadio1")).click();
		
		
		driver.findElement(By.xpath("//input[@type =\"submit\"]")).click();
		
//		
		
		
		
		
		
		
		

	}

}

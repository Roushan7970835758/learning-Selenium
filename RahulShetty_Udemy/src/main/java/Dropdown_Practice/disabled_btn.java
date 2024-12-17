package Dropdown_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class disabled_btn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		System.out.println(driver.findElement(By.xpath("//div[@id=\"Div1\"]")).getAttribute("style").contains("0.5"));
		
		driver.findElement(By.xpath("//div[@id=\"Div1\"]")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[@id=\"Div1\"]")).getAttribute("style").contains("1"));
		
		
		

	}

}

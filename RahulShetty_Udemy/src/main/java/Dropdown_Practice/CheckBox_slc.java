package Dropdown_Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox_slc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		
		List<WebElement> temp = driver.findElements(By.xpath("//input[@id = \"ctl00_mainContent_chk_StudentDiscount\"]"));
		
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id = \"ctl00_mainContent_chk_StudentDiscount\"]")).isSelected());
		// if this assertiin fails the whole tc will fail
		
		for(WebElement test :temp) {
			if(!test.isSelected()) {
				System.out.println(test.getText());
			}
		}

	}

}

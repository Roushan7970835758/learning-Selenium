package Dropdown_Practice;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestion {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("#autosuggest")).sendKeys("ind");
		Thread.sleep(2000);

		List<WebElement> pointers = driver.findElements(By.xpath("//ul[@id =\"ui-id-1\"]//li//a"));

		for (WebElement pointer : pointers) {
			if (pointer.getText().equalsIgnoreCase("India")) {
				pointer.click();
			}
		}

	}

}

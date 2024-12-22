package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tutorialpoint_form_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("name")).sendKeys("Roushan kumar");
		driver.findElement(By.id("email")).sendKeys("rroushan40@gmail.com");
		driver.findElement(By.xpath("//label[contains(text(),\"Other\")]/preceding-sibling::input")).click();
		
		

	}

}

package E2E_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assigment6_dynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		String option = driver.findElement(By.xpath("//input[@id=\"checkBoxOption2\"]//parent::label")).getText();
		System.out.println("The option is: "+ option);
		
		driver.findElement(By.id("checkBoxOption2")).click();
		
		WebElement staticDropdwn = driver.findElement(By.id("dropdown-class-example"));
		
		Select dropdown = new Select(staticDropdwn);
//		dropdown.selectByValue(option);		
		dropdown.selectByContainsVisibleText(option);
		
		driver.findElement(By.id("name")).sendKeys(option);
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
		
		
		

	}

}

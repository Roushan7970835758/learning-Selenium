package javaScriptExecution;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment7_rows_colm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		int rowSize = driver.findElements(By.xpath("//table[@id=\"product\"]//tbody/tr")).size();
		System.out.println("row size : " + rowSize);
		
		int colSize = driver.findElements(By.xpath("//table[@id=\"product\"]//tbody/tr/th")).size();
		System.out.println("column size: " + colSize);
		
		List<WebElement> colDetail = driver.findElements(By.xpath("(//table[@id=\"product\"])[1]//tbody/tr[3]/td"));
		
		for(WebElement temp:colDetail) {
			System.out.println(temp.getText());
		}
				
		
		
		
		

	}

}

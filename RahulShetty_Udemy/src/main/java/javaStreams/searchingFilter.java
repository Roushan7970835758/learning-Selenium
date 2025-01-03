package javaStreams;



import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.tools.javac.util.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class searchingFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> list = driver.findElements(By.xpath("//tr//td[1]"));
		
		List<WebElement> searchedList = list.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		searchedList.stream().forEach(s->System.out.println(s.getText()));
		
		
		
	}

}

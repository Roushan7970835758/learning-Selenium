package Dropdown_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LatestDropdown_LoopintUI {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		for (int i = 0; i < 3; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
			driver.findElement(By.id("hrefIncChd")).click();
			driver.findElement(By.id("hrefIncInf")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();

		// varify selection
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

	}

}

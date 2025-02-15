package selenium4.oLatestFeature;

import java.util.Set;

import org.bouncycastle.util.Arrays.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> windows = driver.getWindowHandles();

		java.util.Iterator<String> it = windows.iterator();
		String Parent = it.next();
		String child = it.next();

		driver.switchTo().window(child);
		driver.get("https://rahulshettyacademy.com/");

		driver.findElement(By.xpath("//li//a[text()=\"Courses\"]")).click();
		String temp = driver
				.findElement(By.xpath("//div[@title='Angular Fundamentals from Scratch & Unit/Integration Testing']"))
				.getText();

		driver.switchTo().window(Parent);
		
		WebElement input = driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']"));

		input.sendKeys(temp);
		System.out.println(input.getRect().getDimension().getHeight());

	}

}

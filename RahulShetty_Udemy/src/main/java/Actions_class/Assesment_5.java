package Actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assesment_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		
		Actions a = new Actions(driver);
		a.contextClick(driver.findElement(By.id("content"))).build().perform();
		
		
		
		
		System.out.println(driver.findElement(By.id("content")).getText());

	}

}

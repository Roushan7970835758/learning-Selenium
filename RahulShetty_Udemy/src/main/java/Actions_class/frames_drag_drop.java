package Actions_class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frames_drag_drop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class=\"demo-frame\"]")));
		
		driver.findElement(By.id("draggable")).click();
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		Actions a = new Actions(driver);
		a.dragAndDrop(source, destination).build().perform();
		
		
		System.out.println("process completed succesfully");

	}

}

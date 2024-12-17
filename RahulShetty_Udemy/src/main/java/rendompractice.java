import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class rendompractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.pexels.com/search/beautiful/");
		
		 List<WebElement> imageElements = driver.findElements(By.xpath("//a/img"));
		 
		 List<String> ImgSource = new ArrayList<>();
		 
		 for(WebElement img :imageElements) {
			 String src = img.getAttribute("src");
			 
			 ImgSource.add(src);
			 System.out.println(src);
			 }
		 
		 for(String temp: ImgSource) {
			 driver.get(temp);
			 
			 Thread.sleep(3000);
		 }
	}

}

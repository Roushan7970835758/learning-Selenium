package E2E_practice;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import io.github.bonigarcia.wdm.WebDriverManager;

public class extractAllLinks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
//Get all links prasent on the page
		
		List <WebElement> links = driver.findElements(By.tagName("a"));
		
		Iterator <WebElement> it = links.iterator();
		
		int i=0;
		while(it.hasNext()) {
			i++;
			System.out.println(it.next().getAttribute("href"));
		}
		System.out.println(i);
		
//links on footer sections
		List<WebElement> links2 = driver.findElements(By.xpath("//div[@id=\"gf-BIG\"]//a"));
		System.out.println(links2.size());
		
		Iterator <WebElement> it2 = links2.iterator();
		
		
		while(it2.hasNext()) {
			System.out.println(it2.next().getAttribute("href"));
		}
		
//opening each link in footer one section
		
		
		WebElement footerLink = driver.findElement(By.xpath("//div[@id=\"gf-BIG\"]//td[1]//ul"));
		Actions a = new Actions(driver);
		
		for(int m=1;m<footerLink.findElements(By.tagName("a")).size();m++) {
//			a.moveToElement(footerLink.findElements(By.tagName("a")).get(m)).keyDown(Keys.CONTROL).click().build().perform();
			String openInTabs = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			footerLink.findElements(By.tagName("a")).get(m).sendKeys(openInTabs);
			Thread.sleep(5000);
			
		}

// get the title of each tab
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it3 = windows.iterator();
		it3.next();
		
		while(it3.hasNext()) {
			System.out.println(driver.switchTo().window(it3.next()).getTitle());
		}
		
		
		
		
		
		
System.out.println("process Completed");
		
		
		
		

	}

}

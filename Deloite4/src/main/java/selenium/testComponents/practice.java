package selenium.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice {
public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='New Tab']")));
		
		WebElement selectEle = driver.findElement(By.xpath("//button[@title='New Tab']"));
		
		Select select = new Select(selectEle);
		select.selectByValue("test");
		
		
		//window handling
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		
		Iterator<String> it = allWindows.iterator();
		
		
		String ParentwindowIT = it.next();
		String childWindowIT = it.next();
		
		//action
		Actions a = new Actions(driver);
		a.moveToElement(selectEle).keyDown(Keys.SHIFT).sendKeys("roushan").build().perform();
		
		//switching to new window
		driver.switchTo().newWindow(WindowType.TAB);
		
		//javascript
		JavascriptExecutor js = (JavaScriptExecutor) driver;
		js.executeScript("document[0].click();", selectEle);
		
		
		//seiching window based on title
		String parentWindow1 = driver.getWindowHandle();
		
		for(String WindowHandles:driver.getWindowHandles()) {
			driver.switchTo().window(windoeHandles);
			if(driver.getTitle().equalsIgnoreCase("Home")) {
				System.out.println("Switched to window with title: " + driver.getTitle());
				break;
			} else {
				System.out.println("Not the desired window, current title: " + driver.getTitle());
			}
		}
		
		
		
	}

public String getScreenshot(String name,WebDriver driver) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir") + "\\reports\\" + name + LocalDateTime.now() + ".png";
	
	FileUtils.copyFile(source, new File(destination));
	return destination;
}

public void readProperties(String property) throws IOException {
	Properties props = new Properties();
	FileInputStream fis = new FileInputStream("\\paht\\sdfe");
	
	props.load(fis);
	props.getProperty(property);
	
}
}

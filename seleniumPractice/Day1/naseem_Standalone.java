package Day1;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class naseem_Standalone {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	        // Specify the debugging port (you must enable remote debugging when opening Chrome)
	        String chromeDebuggingPort = "9222";  // Change this if needed

	        // Set Chrome options
	        ChromeOptions options = new ChromeOptions();
	        options.setExperimentalOption("debuggerAddress", "localhost:" + chromeDebuggingPort);

	        // Initialize WebDriver
//	        WebDriver driver = new ChromeDriver(options);
	        
	        WebDriver driver = new ChromeDriver();
	        
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        
	        driver.get("https://staging.ableteams.com/wfm/#/login");
	        driver.findElement(By.id("1-email")).sendKeys("nbanuh@allegisgroup.com");
	        driver.findElement(By.id("1-password")).sendKeys("Nb@78686");
	        driver.findElement(By.id("1-submit")).click();
	        
	        System.out.println("Login Completed");
//	        
	        driver.findElement(By.id("mat-input-0")).sendKeys("daylon daylon");
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//div[contains(text(),' Daylon daylon ')]")).click();
	        Thread.sleep(3000);
	        
//	        driver.findElement(By.xpath("//button[contains(text(),'Login as ddaylon876818')]")).click();
	      //using java Script 
	        WebElement Login_ddaylon876818 =   driver.findElement(By.xpath("//button[contains(text(),'Login as ddaylon876818')]"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Login_ddaylon876818);
	        
	        Thread.sleep(2000);
	        
	        WebElement reasonForLogin_dropdown = driver.findElement(By.xpath("//select[@ng-model ='reasonForLoginAnswers.reasonType']"));
	        Select reasonForLogin_select = new Select(reasonForLogin_dropdown);
	        reasonForLogin_select.selectByIndex(1);
//	        
	        driver.findElement(By.xpath("//textarea[@placeholder='Details']")).sendKeys("temp testing Roushan Kumar");
	        driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
	        
	        
	        //here two tabs open 
	        //switch to child tab
	        Thread.sleep(3000);
	        Set<String> window = driver.getWindowHandles();
			
			Iterator<String> it = window.iterator();
			
			String parent = it.next();
			String child1 = it.next();
			System.out.println(parent + child1 );
			
			
			driver.switchTo().window(child1);
			


	        
	        
	        
	        
	        System.out.println("Process Completed");
	        
	        
	        
	        

	}

}

package selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firstPractice {
	@FindBy(id="confirmbtn")
	WebElement cnfBtn;

	@Test
	public void lounchChrome() throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(option);
		
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement selector = driver.findElement(By.id("dropdown-class-example"));
		
		Select options = new Select(selector);
		options.selectByIndex(1);
		

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.google.com");
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("pass")).sendKeys("Roushan");
		
		Set<String> window = driver.getWindowHandles();
		
		Iterator<String> it = window.iterator();
		
		String parent = it.next();
		String child1 = it.next();
		String child2 = it.next();
		
		driver.switchTo().window(parent);		
		
		driver.findElement(By.id("autocomplete")).sendKeys("Ind");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='India']")));
		driver.findElement(By.xpath("//div[text()='India']")).click();
		
		driver.findElement(By.id("autocomplete")).clear();
		
		Actions a = new Actions(driver);
		
		
		WebElement alert = driver.findElement(By.id("name"));	
		
		a.moveToElement(alert).click().keyDown(Keys.SHIFT).sendKeys("Rousnan").build().perform();
		driver.findElement(By.id("alertbtn")).click();
		
		driver.switchTo().alert().accept();
		
		cnfBtn.click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		Thread.sleep(2000);
		a.scrollByAmount(0, 400);
		
		HttpURLConnection  connection = new URL()
		
		
		
		
	}
}

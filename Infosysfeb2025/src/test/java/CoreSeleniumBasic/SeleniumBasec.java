package CoreSeleniumBasic;


import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBasec {
	
	public final int a=10;
	
	@FindBy(xpath ="//table[@name='courses']//tr//td[3]")
	List<WebElement> prices;
	
	@Test
	public void basic() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		
		
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("--headless");
		
		
	         WebDriver driver = new ChromeDriver();
	         driver.manage().window().maximize();
		 
	 		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	 		 PageFactory.initElements(driver, this);
		 
	 		//implecit wait
//	 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
	 		
	 		
	 		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
	 		Select option = new Select(dropdown);
	 		option.selectByIndex(2);
	 		
	 		Actions action = new Actions(driver);
	 		WebElement find = driver.findElement(By.id("autocomplete"));
	 		action.moveToElement(find).click().keyDown(Keys.SHIFT).sendKeys("Ind").build().perform();
	 		
	 		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='India']")));
	 		driver.findElement(By.xpath("//div[text()='India']")).click();
	 		
	 		driver.findElement(By.id("name")).sendKeys("Roushan");
	 		driver.findElement(By.id("alertbtn")).click();
	 		
	 		driver.switchTo().alert().accept();
	 		
	 		driver.navigate().to("https://www.google.com");
	 		driver.navigate().back();
	 		
//	 		action.contextClick(driver.findElement(By.id("show-textbox")));
//	 		Thread.sleep(2000);
//	 		action
//	 			.sendKeys(Keys.ARROW_DOWN)
//	 			.sendKeys(Keys.ARROW_DOWN)
//	 			.sendKeys(Keys.ENTER).build().perform();
	 		
	 		driver.findElement(By.id("checkBoxOption2")).click();
	 		
	 		driver.switchTo().newWindow(WindowType.TAB);
	 		driver.get("https://www.google.com");
	 		
	 		Set<String> window = driver.getWindowHandles();
	 		
	 		Iterator<String> it = window.iterator();
	 		
	 		String parentId = it.next();
	 		String childId = it.next();
	 		driver.switchTo().window(parentId);
	 		
	 		JavascriptExecutor js = (JavascriptExecutor)driver;
	 		
	 		js.executeScript("window.scrollBy(0,500)");

	 		
		
		
	}

}

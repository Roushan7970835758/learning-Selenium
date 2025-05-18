package EComTesting;



import java.time.Duration;
import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	
	@FindBy(id="login")
	WebElement Sign_btn;
	
	@AfterMethod
	public void openGoogle() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
	}
	
	@Test
	public  void lonchApplication() throws InterruptedException {
		
		System.out.println("Test Starts: ");
		

		WebDriverManager.chromedriver().setup();
		 
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--window-size=1280,800");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
		
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		
//		action.moveToElement(driver.findElement(By.id("userEmail"))).click().keyDown(Keys.SHIFT).sendKeys("Roushan").build().perform();
		driver.findElement(By.id("userEmail")).sendKeys("roushan@gmail.com");
		
		
		
		driver.findElement(By.id("userPassword")).sendKeys("Roushan@123");
		
		Sign_btn.click();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.facebook.com");
		
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		
		Set<String> window = driver.getWindowHandles();
		
		Iterator<String> it = window.iterator();
		
		String Parent = it.next();
		String child = it.next();
		
		driver.switchTo().window(Parent);
		Thread.sleep(3000);

		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		w.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath("//button[contains(text(),' Sign Out ')]"))));
		
		
		driver.findElement(By.xpath("//button[contains(text(),' Sign Out ')]")).click();
		action.contextClick(driver.findElement(By.id("userEmail"))).build().perform();
		
		
		
		}
	@Test(groups={"reg"})
	public void practiceWeb() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.tutorialspoint.com/selenium/practice/droppable.php");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		action.dragAndDrop(draggable, droppable).build().perform();
		
	}
	

}























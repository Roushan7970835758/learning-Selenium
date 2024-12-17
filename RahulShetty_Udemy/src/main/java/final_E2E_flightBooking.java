import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class final_E2E_flightBooking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#autosuggest")).sendKeys("ind");
		Thread.sleep(2000);

		List<WebElement> pointers = driver.findElements(By.xpath("//ul[@id =\"ui-id-1\"]//li//a"));

		for (WebElement pointer : pointers) {
			if (pointer.getText().equalsIgnoreCase("India")) {
				pointer.click();
			}
		}
		
		
		
		//selecting the stations
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),\" Kolkata (CCU)\")]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"]//a[contains(text(),\" Patna (PAT)\")]")).click();
		
		
		
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		//selecting the no. of passangers
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		for (int i = 0; i < 3; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
			driver.findElement(By.id("hrefIncChd")).click();
			driver.findElement(By.id("hrefIncInf")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();

		// varify selection
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		
		//checkbox selection
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		
		
		//selecting the currency
WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);
//		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		dropdown.selectByValue("AED");
		
//		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		dropdown.selectByVisibleText("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//clicking on search
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		
		System.out.println("process completed");
		
		
		
		

	}

}

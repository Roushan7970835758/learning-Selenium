package Day1;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon_OpenBrs {
	public static void main(String[] args) throws InterruptedException {
		String chromeDebuggingPort = "9222"; // Change this if needed
		// Set Chrome options
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "localhost:" + chromeDebuggingPort);
		// Initialize WebDriver
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))
				.sendKeys("I Phone 16");
		Thread.sleep(3000);
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath(
				"//span[contains(text(),'iPhone 16 128 GB: 5G Mobile Phone with Camera Control, A18 Chip and a Big Boost in Battery Life. Works with AirPods; Black')]"))
				.click();
		// here two tabs open ---> navigate to child tab
		Thread.sleep(3000);
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String parent = it.next();
		String child1 = it.next();
		System.out.println("The two tabs are: " + parent +" "+ child1);
		driver.switchTo().window(child1);
		driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
		// Locate the "Added to Cart" confirmation message
        WebElement confirmationMessage = driver.findElement(By.xpath("(//h4[contains(text(),'Added to cart')])[2]"));
        // Assertion to check if the message is displayed
        assert confirmationMessage.isDisplayed() : "Added to Cart message not found!";
        System.out.println("Assertion Passed: 'Added to Cart' message is visible.");

	}

}

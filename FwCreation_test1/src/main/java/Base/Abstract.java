package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstract {
	public static WebDriver driver;
	
	WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public void waitForele(WebElement ele) {
		w.until(ExpectedConditions.visibilityOf(ele));
	}
	public void waitForele(By ele) {
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ele));
	}
	public void ScrollToView(WebElement ele) {
		 js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
}

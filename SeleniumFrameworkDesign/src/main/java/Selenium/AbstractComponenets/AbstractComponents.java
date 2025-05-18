package Selenium.AbstractComponenets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Selenium.pageObjects.cartPage;
import Selenium.pageObjects.ordersPage;

public class AbstractComponents {
	
	WebDriver driver;
	@FindBy(xpath="//button[contains(text(),' Cart' )]")
	WebElement cartBtn;
	
	@FindBy(xpath="//button[contains(text(),' ORDERS' )]")
	WebElement orderBtn;
	
	

	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForEleToAppear(By findBy) {
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.presenceOfElementLocated(findBy));
	}
	public void waitForEleToAppear(WebElement element) {
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(8));
		w.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void waitForEleToDisApper(WebElement element) throws InterruptedException {
		Thread.sleep(2000);
//		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
//		w.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public cartPage goToCart() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", cartBtn);
		Thread.sleep(2000);
		waitForEleToAppear(cartBtn);
		cartBtn.click();
		return new cartPage(driver);
	
		}
	public ordersPage goToOrders() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", orderBtn);
		Thread.sleep(2000);
		waitForEleToAppear(orderBtn);
		orderBtn.click();
		return new ordersPage(driver);
	
		}
	
}

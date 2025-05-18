package Selenium.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbstractComponenets.AbstractComponents;

public class cartPage extends AbstractComponents {
	public  cartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		 PageFactory.initElements(driver, this);
		
	}

	WebDriver driver;
	
 	@FindBy (xpath="//div[@class='infoWrap']//h3")
 	List <WebElement> kartItem;
 	
 	@FindBy (xpath="//button[contains(text(),'Checkout')]")
 	WebElement checkoutBtn;
 
 
 public boolean varifyProductDisplay(String pName){
	 for(WebElement em: kartItem) {
		 if(em.getText().equalsIgnoreCase(pName)) {
			 return true;
		 }		 
	 }
	 return false;
 }
 
 public checkoutPage goToCheckout() throws InterruptedException {
	 checkoutBtn.click();
	 Thread.sleep(2000);
	 return new checkoutPage(driver);
 }
 

 
 
}

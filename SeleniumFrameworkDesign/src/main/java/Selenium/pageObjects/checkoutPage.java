package Selenium.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbstractComponenets.AbstractComponents;

public class checkoutPage extends AbstractComponents {
	WebDriver driver;
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countrySelector;
	
	@FindBy(xpath="//button[@type='button']")
	List<WebElement> countryList;
	@FindBy(xpath="//a[contains(text(),'Place Order ')]")
	WebElement placeOrderBtn;
	
	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectCountry(String name) {
		Actions a = new Actions(driver);
		a.sendKeys(countrySelector, name).build().perform();
		waitForEleToAppear(driver.findElement(By.cssSelector(".ta-results")));
		
		for(WebElement em: countryList) {
			if(em.getText().equalsIgnoreCase(name)) {
				em.click();
			}
		}
		
	}
	public conformationPage submitOrder() {
		placeOrderBtn.click();
		return new conformationPage(driver);
	}

}

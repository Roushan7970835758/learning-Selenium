package Selenium.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbstractComponenets.AbstractComponents;

public class ordersPage extends AbstractComponents{
	
	WebDriver driver;
	
	@FindBy(xpath="//tr[@class='ng-star-inserted']//td[2]")
	List<WebElement> orderProducts;

	public ordersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean varifyOrdersDisplay(String ProductName) {
		for(WebElement em: orderProducts) {
			if(em.getText().equalsIgnoreCase(ProductName))
				return true;
		}
		return false;
	}
	
}

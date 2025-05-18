package Selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Selenium.AbstractComponenets.AbstractComponents;

public class conformationPage extends AbstractComponents {
	public WebDriver driver;
	
	@FindBy(xpath="//label[@class='ng-star-inserted']")
	WebElement orderNum;
	
	@FindBy(className="hero-primary")
	WebElement cmfNum;
	
	
	
	public conformationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public String getComfMsg() {
		waitForEleToAppear(cmfNum);
		
		return cmfNum.getText();
	}
	public String getOrderNum() {
		waitForEleToAppear(orderNum);
		return orderNum.getText();
	}

}

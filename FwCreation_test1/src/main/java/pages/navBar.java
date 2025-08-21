package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Library;

public class navBar extends Library {
	
	public navBar() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='dropdown']//span[contains(text(),'My Account')]")
	WebElement dorpdown;
	
	public void clickOnDropdown(String drpdownName) {
		
		driver.findElement(By.xpath("//div[@class='dropdown']//span[contains(text(),'"+drpdownName+"')]")).click();
	}
	public void clickOnOptionsInDrpDown(String name) {
		WebElement ele = driver.findElement(By.xpath("//a[@class='dropdown-item' and contains(text(),'"+name+"')]"));
		waitForele(ele);
		ele.click();
	}
}

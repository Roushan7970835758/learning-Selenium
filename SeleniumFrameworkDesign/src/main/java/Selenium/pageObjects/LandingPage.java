package Selenium.pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbstractComponenets.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;

	@FindBy(id="userEmail")
	public WebElement userEmail;
	
	
	@FindBy(id="userPassword")
	public WebElement userPassword;
	
	@FindBy(id="login")
	public WebElement SubmitBtn;
	
	@FindBy(xpath="//div[contains(@class,'ng-trigger-flyInOut')]")
	WebElement ErrMsg;
	

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver= driver;	
		PageFactory.initElements(driver, this);
		}
	
	public void goTo() throws IOException {
		Properties props = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\\\src\\\\main\\\\java\\\\Selenium\\\\resources\\\\GlobalData.properties");
		
		props.load(fis);
		
		driver.get(props.getProperty("AppUrl"));
	}
	
	public productCatalog loginApplication(String userEmail,String userPass) throws InterruptedException {
		this.userEmail.sendKeys(userEmail);
		this.userPassword.sendKeys(userPass);
		SubmitBtn.click();
		return new productCatalog(driver);
	}
	
	public String getErrorMsg() {
		waitForEleToAppear(ErrMsg);
		return ErrMsg.getText();
	}
	

}

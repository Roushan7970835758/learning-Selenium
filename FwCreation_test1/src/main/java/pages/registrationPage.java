package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Library;

public class registrationPage extends Library {
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	public registrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	WebElement firstName;
	
	@FindBy(id="input-lastname")
	WebElement lastName;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement continueBtn;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement privecyCheck;
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement contBtn_accConfPg;
	
	@FindBy(xpath="//div//h1")
	WebElement sucessMsg;
	
	@FindBy(xpath="//ul[@class='breadcrumb']//li/a[text()='Account']")
	WebElement AccountPage;
	
	public void enterFirstName(String fname) { firstName.sendKeys(fname); }
    public void enterLastName(String lname) { lastName.sendKeys(lname); }
    public void enterEmail(String mail) { email.sendKeys(mail); }
    public void enterPassword(String pass) { password.sendKeys(pass); }
    
    public void checkPrivecy() {
    	
    	ScrollToView(privecyCheck);
    	js.executeScript("arguments[0].click();", privecyCheck);
//    	privecyCheck.click();
    	}
    public void clickConfBtn() { 
    	ScrollToView(continueBtn);
    	continueBtn.click(); 
    	}
    
    public void clickConBtn_AccountSuccesPage() throws InterruptedException {
    	Thread.sleep(3000);
    	String success_message = sucessMsg.getText();
    	Assert.assertEquals(success_message, "Your Account Has Been Created!");
    	contBtn_accConfPg.click();
    }
    
    public void confmAccPage() {
//    	element is visible
    	boolean isdisplayed = AccountPage.isDisplayed();
    	Assert.assertTrue(isdisplayed);
    }
	
	
	
	
}

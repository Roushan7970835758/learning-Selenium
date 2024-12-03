import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class signIn_locatorsPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		
		WebElement inputField = driver.findElement(By.xpath("//input[@id=\"inputUsername\"]"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@type=\"password\"]"));
		WebElement checkBox1 = driver.findElement(By.id("chkboxOne"));
		WebElement checkBox2 = driver.findElement(By.id("chkboxTwo"));
		WebElement signInBtn = driver.findElement(By.xpath("//button[contains(text(),\"Sign In\")]"));
		
		inputField.sendKeys("test_user");
		
	
		
		passwordField.sendKeys("test_password");
		
		
		
		if(!checkBox1.isSelected()) {
			checkBox1.click();
			}
		
		
		if(!checkBox2.isSelected()) {
			checkBox2.click();
			}
		
		
		
		signInBtn.click();		
		Thread.sleep(5000); // 3000 milliseconds = 3 seconds
		
		try {
			WebElement ErrorMsg = driver.findElement(By.xpath("//p[contains(text(),\"* Incorrect username or password\")]"));
			
			
			if(ErrorMsg.isDisplayed()) {
				
				System.out.println("Error msg is displayed succesfully, proceed to forgot password");
				
				WebElement ForgotPassBtn = driver.findElement(By.xpath("//a[contains(text(),\"Forgot your password?\")]"));
				System.out.println("forgot password btn found");
				
				ForgotPassBtn.click();
				Thread.sleep(5000);
				
				WebElement formName = driver.findElement(By.xpath("//form//input[@placeholder=\"Name\"]"));
				formName.sendKeys("Roushan");
				
				WebElement formEmail = driver.findElement(By.xpath("//form//input[@placeholder=\"Email\"]"));
				formEmail.sendKeys("rroushan@gmaili.com");
				
				WebElement formPhoneNum = driver.findElement(By.xpath("//form//input[@placeholder=\"Phone Number\"]"));
				formPhoneNum.sendKeys("339944888");
				
				WebElement ResetLogBtn = driver.findElement(By.xpath("//button[contains(text(),\"Reset Login\")]"));
				ResetLogBtn.click();
				
				
				
				WebElement NewPassText = driver.findElement(By.xpath("//p[contains(text(),\"Please use temporary password 'rahulshettyacademy' to Login.\")]"));
				WebElement GoToLogBtn = driver.findElement(By.xpath("//button[contains(text(),\"Go to Login\")]"));
				
				
				
				
				
				
				
				
				
					
				
				//extract new password
				String str = NewPassText.getText();
				
				String[] str_arr = str.split(" ");
				
				String str_pass = str_arr[4];
				System.out.println("Temp password is "+ str_pass);
				
				GoToLogBtn.click();
				Thread.sleep(3000);
				
				
				
				//input the username & temp pass
				boolean isVarified = false;
				
				while(isVarified == false) {
					inputField.sendKeys("test_user");
					passwordField.sendKeys(str_pass);
					
					
					if(!checkBox1.isSelected()) {
						checkBox1.click();
						}
					
					
					if(!checkBox2.isSelected()) {
						checkBox2.click();
						}
					WebElement signInBtn2 = driver.findElement(By.xpath("//button[contains(text(),\"Sign In\")]"));
					signInBtn2.click();
					System.out.println("clicked on sign in btn again: ");
					Thread.sleep(5000);
					
					try{
						WebElement varifyTxt = driver.findElement(By.xpath("//h1[contains(text(),\"Welcome to \")]"));
						System.out.println("varification text coutgh ");
						isVarified = true;
						
					}catch(org.openqa.selenium.NoSuchElementException e){
						System.out.println("multiple varification process error");
					}
					
					
					
				}
				
				
								
			}
			
		}catch(org.openqa.selenium.NoSuchElementException e){
			System.out.println("catch error");
		}
		
		
		
//		driver.close();

	}

}

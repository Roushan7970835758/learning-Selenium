import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class final_rahulsetty_login_page {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-nerated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new EdgeDriver();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id=\"inputUsername\"]")).sendKeys("test_User");
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("tempPass");
		
		driver.findElement(By.xpath("//button[contains(text(),\"Sign In\")]")).click();
		
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),\"Sign In\")]")).click();
		String str = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(str);
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//form//input[@placeholder=\"Name\"]")).sendKeys("Roushan");
		
		driver.findElement(By.xpath("//form//input[@placeholder=\"Email\"]")).sendKeys("rrr@gmail.com");
		
		driver.findElement(By.xpath("//form//input[@placeholder=\"Phone Number\"]")).sendKeys("7970835758");
		
		driver.findElement(By.xpath("//button[contains(text(),\"Reset Login\")]")).click();
		
		String pass_str = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		
		String[] str_arr = pass_str.split(" ");
		String password = str_arr[4].substring(1,str_arr[4].length()-1);
		System.out.println(password);
		
		driver.findElement(By.xpath("//button[contains(text(),\"Go to Login\")]")).click();
		
		driver.findElement(By.xpath("//input[@id=\"inputUsername\"]")).sendKeys("test_User");
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(password);
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.signInBtn")).click();
		System.out.println("sign in clicked succesfully");
		
		if(driver.findElement(By.xpath("//h1[contains(text(),\"Welcome to \")]")).isDisplayed()) {
			System.out.println(driver.findElement(By.xpath("//h1[contains(text(),\"Welcome to \")]")).getText());
			System.out.println("process completed !!!");
		}
		driver.findElement(By.xpath("//*[text()=\"Log Out\"]")).click();
		
		driver.close();
		
		
		
		
		
		
		
	}

}

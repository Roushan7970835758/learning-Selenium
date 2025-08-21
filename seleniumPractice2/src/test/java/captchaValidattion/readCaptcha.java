package captchaValidattion;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


import io.github.bonigarcia.wdm.WebDriverManager;

public class readCaptcha {
	public static void main(String[] args) throws IOException, InterruptedException, TesseractException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		try {
			driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'OK')]")).click();
			//button[@type='submit' and contains(text(),'OK')]
			
		}catch(Exception e) {
			System.out.println("OK popup not found");
		}
		driver.findElement(By.xpath("//a[contains(text(),' LOGIN ')]")).click();
		
		WebElement captchaImg = driver.findElement(By.xpath("//div[@class='captcha_div']//img[@class='captcha-img']"));
		File src = captchaImg.getScreenshotAs(OutputType.FILE);
		String path = "C:\\Users\\User\\eclipse-workspace\\TODO\\seleniumPractice2\\src\\test\\captchaImg\\captcha.png";
		FileHandler.copy(src, new File(path));
		Thread.sleep(2000);
		
		ITesseract image = new Tesseract();
		
		image.setDatapath("C:\\Users\\User\\eclipse-workspace\\TODO\\seleniumPractice2\\data"); // Use double backslashes for Windows path
		image.setLanguage("eng");          // Make sure the file name is eng.traineddata

		
		String str = image.doOCR(new File(path));
		
		System.out.println("the string of catpcha is: "+ str);
		
		driver.findElement(By.xpath("//input[@id='captcha']")).sendKeys(str);
		
		
	}

}

















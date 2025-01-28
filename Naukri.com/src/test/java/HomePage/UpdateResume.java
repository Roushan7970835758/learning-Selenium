package HomePage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import LoginPage.BeforeLogin;

public class UpdateResume extends BeforeLogin {
	
	@Test(groups= {"applyUpdate"})
	public void UpdateResume() throws InterruptedException {
		driver.findElement(By.className("nI-gNb-drawer__bars")).click();
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("nI-gNb-info__sub-link")));
		driver.findElement(By.className("nI-gNb-info__sub-link")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("dummyUpload")));
		// Locate the hidden file input element
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        // Make the hidden input visible using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='block';", fileInput);
        // Upload the file using sendKeys
        fileInput.sendKeys("C:\\Users\\User\\Downloads\\QA_Roushan_resume.pdf");
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Resume has been successfully uploaded.')]")).isDisplayed());
		
		Thread.sleep(5000);		
		System.out.println("Process completed");
		
	}

}

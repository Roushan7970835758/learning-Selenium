package HomePage;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginPage.BeforeLogin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AfterLogin extends BeforeLogin {

	@Test(groups= {"applyUpdate"})
	public void SearchJob() throws InterruptedException {

		WebDriver driver = BeforeLogin.driver;
		String JobSkill = "Java, Selenium, API Automation, API Testing, Robot Framework, Worksoft Certify, QA automation, Rest API Testing, SDET, Software testing, Testng, Cucumber";

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("view-profile-wrapper")));

		driver.findElement(By.xpath("//span[contains(text(),'Search jobs here')]")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("suggestor-input")));
		driver.findElement(By.xpath("//input[@class='suggestor-input ']")).sendKeys(JobSkill);
		driver.findElement(By.id("experienceDD")).click();

		WebElement Exp_dropdown = driver.findElement(By.id("experienceDD"));

		Actions action = new Actions(driver);

		action.moveToElement(Exp_dropdown).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

		driver.findElement(By.xpath("//span[text()='Search']")).click();

		Thread.sleep(3000); // Just to make sure the page is fully loaded
		List<WebElement> jobPost = driver.findElements(By.className("srp-jobtuple-wrapper"));

		for (int j = 0; j < 8; j++) {
			for (int i = 0;i< jobPost.size(); i++) {

				jobPost.get(i).click();

				w.until(ExpectedConditions.numberOfWindowsToBe(2));

				Set<String> windows = driver.getWindowHandles();

				Iterator<String> it = windows.iterator();
				String parentId = it.next();
				String childId = it.next();

				driver.switchTo().window(childId);

				Thread.sleep(1000);

				if (!driver.findElements(By.id("company-site-button")).isEmpty()) { // go to company and out of scope
					// close the tab
					driver.close();

					driver.switchTo().window(parentId);
				} else if (!driver.findElements(By.id("apply-button")).isEmpty()) {

					// apply for the job
					driver.findElement(By.xpath("//button[text()='Apply']")).click();

					if (!driver.findElements(By.className("apply-message")).isEmpty()) {
						String apply_msg = driver.findElement(By.className("apply-message")).getText();
						System.out.println(apply_msg);
						Thread.sleep(2000);
					}

					// close the tab
					driver.close();

					driver.switchTo().window(parentId);

				}

			}
			driver.findElements(By.xpath("//div[@class='styles_pages__v1rAK']//a")).get(j).click();
		}

	}
}

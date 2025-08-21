package pages;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Base.Library;
import org.testng.Assert;

public class homePage extends Library {
	

		public homePage() {
			PageFactory.initElements(driver, this);
		}
	
	
	
	public void validateHomePage() {
		String url_Home = driver.getCurrentUrl();
//		System.out.println(url_Home);
		Assert.assertEquals(url_Home, "https://demo.opencart.com/");
	}
}

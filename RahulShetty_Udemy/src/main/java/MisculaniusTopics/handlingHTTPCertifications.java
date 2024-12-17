package MisculaniusTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class handlingHTTPCertifications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		ChromeDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());

	}

}

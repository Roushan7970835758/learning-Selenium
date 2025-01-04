package Selenium.ExtendReports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtendReportsdemo {
	public ExtentReports extent;
	
	@BeforeTest
	public void config() {
		
		
		//ExtendReport, ExtendSparkReproter
		String path = System.getProperty("User.dir")+ "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		 
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "Roushan Kumar");
		
		
	}
	
	@Test
	public void initialDemo() {
		
		
		WebDriverManager.chromedriver().setup();
		ExtentTest test = extent.createTest("Initial Demo");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		
		test.fail("The result doesnot match");
//		test.addScreenCaptureFromBase64String(OutputType.BASE64);
		
		extent.flush();
		driver.close();
	}
}

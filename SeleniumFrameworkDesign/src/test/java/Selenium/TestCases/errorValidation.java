package Selenium.TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sun.net.httpserver.Authenticator.Retry;

import Selenium.pageObjects.LandingPage;
import Selenium.pageObjects.cartPage;
import Selenium.pageObjects.checkoutPage;
import Selenium.pageObjects.conformationPage;
import Selenium.pageObjects.productCatalog;
import Selenium.testComponents.baseTest;
import Selenium.testComponents.retry;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class errorValidation extends baseTest {
	ExtentReports extent;
	@Test(groups= {"errorVal"},retryAnalyzer=retry.class,dataProvider="getData")
	public void loginErrorValidation(HashMap<String,String> input) throws IOException, InterruptedException {
		
		String item_name = input.get("item_name");

		productCatalog p1 = l1.loginApplication(input.get("email"), "wrontPsw");

		String ErrorMsg = l1.getErrorMsg();
		Assert.assertEquals("Incorrect email or password.", ErrorMsg);

	}

	@Test(groups = {"errorVal"},retryAnalyzer=retry.class,dataProvider="getData")
	@Description("Product should not be in cart page if not added")
	@Severity(SeverityLevel.MINOR)
	public void productErrorValidation(HashMap<String,String> input) throws InterruptedException {
		String item_name = "wrontItemName";
		
		productCatalog p1 = l1.loginApplication(input.get("email"), input.get("password"));
		
		p1.addProdToCart(item_name);
		cartPage c1 = p1.goToCart();
		boolean match = c1.varifyProductDisplay(item_name);
		Assert.assertFalse(match);
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
	    String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\Selenium\\data\\purchaseOrder.json";
	    System.out.println("File path: " + filePath);
	    
	    List<HashMap<String, String>> data = getJsonDataToMap(filePath);
	    if (data == null || data.isEmpty()) {
	        throw new RuntimeException("No data found in the JSON file: " + filePath);
	    }
	    return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
}

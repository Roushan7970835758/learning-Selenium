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

import Selenium.pageObjects.LandingPage;
import Selenium.pageObjects.cartPage;
import Selenium.pageObjects.checkoutPage;
import Selenium.pageObjects.conformationPage;
import Selenium.pageObjects.ordersPage;
import Selenium.pageObjects.productCatalog;
import Selenium.testComponents.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class submitOrder extends baseTest {
	WebDriver driver;
	@Test(dataProvider="getData", groups = {"purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		
		String item_name = input.get("item_name");
		
		productCatalog p1 = l1.loginApplication(input.get("email"), input.get("password"));
		
		p1.addProdToCart(item_name);
		cartPage c1 = p1.goToCart();
		boolean match = c1.varifyProductDisplay(item_name);
		Assert.assertTrue(match);
		checkoutPage ck1 = c1.goToCheckout();
		ck1.selectCountry("India");
		conformationPage cmf1 = ck1.submitOrder();
		String OrderNum = cmf1.getOrderNum();
		System.out.println("order Num is : "+ OrderNum);
		String comfmMsg = cmf1.getComfMsg();
		System.out.println("conform msg is : "+comfmMsg);
		 driver =cmf1.driver;
		
		Assert.assertTrue(comfmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}
	
	@Test(dependsOnMethods= {"submitOrder"},dataProvider="getData")
	public void orderHistoryTest(HashMap<String,String> input) throws InterruptedException {
		productCatalog p1 = l1.loginApplication(input.get("email"), input.get("password"));
		ordersPage odp1= p1.goToOrders();
		boolean orderDisplay = odp1.varifyOrdersDisplay(input.get("item_name"));
		Assert.assertTrue(orderDisplay);
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

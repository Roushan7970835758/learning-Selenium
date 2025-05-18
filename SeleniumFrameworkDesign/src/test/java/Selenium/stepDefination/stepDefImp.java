package Selenium.stepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Selenium.pageObjects.LandingPage;
import Selenium.pageObjects.cartPage;
import Selenium.pageObjects.checkoutPage;
import Selenium.pageObjects.conformationPage;
import Selenium.pageObjects.productCatalog;
import Selenium.resources.extentReporterNg;
import Selenium.testComponents.baseTest;
import io.cucumber.java.*;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.aventstack.extentreports.Status;

public class stepDefImp extends baseTest{
	public LandingPage landingPage;
	public productCatalog productCatalog_test;
	public cartPage c1;
	public checkoutPage ck1;
	public conformationPage cm1;
	
	

	@Given ("I landed on Ecomerce page")
	public void I_landed_on_Ecomerce_page() throws IOException {
		landingPage = launchApplication();
	}
	
	@Given ("^login using the username (.+) and password (.+)$")
	public void login_using_the_username_and_password(String username, String password) throws InterruptedException {
		 productCatalog_test = landingPage.loginApplication(username, password);
	}
	
	@When("^I add product (.+) from kart")
	public void I_add_product_from_Kart(String productName) throws InterruptedException {
		List<WebElement> element = productCatalog_test.getProdList();
		WebElement prod = productCatalog_test.getProdbyName(productName);
		productCatalog_test.addProdToCart(productName);
	}
	
	@And ("^Checkout product (.+) and submit the order$")
	public void  Checkout_Submit_order(String productName) throws InterruptedException {
		 c1 = productCatalog_test.goToCart();

		boolean match = c1.varifyProductDisplay(productName);
		Assert.assertTrue(match);
		 ck1 = c1.goToCheckout();		
		ck1.selectCountry("India");
		 cm1 = ck1.submitOrder();
	}
	
	@Then("{string} Message displayed on ComformationPage")
	public void Message_displayed_ComformationPage(String msg) {
		String cnfMsg = cm1.getComfMsg();				
		Assert.assertTrue(cnfMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	

}

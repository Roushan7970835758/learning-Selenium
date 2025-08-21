package stepDefination;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Base.Library;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.homePage;

public class background extends Library{
	
	homePage hmpg = new homePage();
	
	
	@Given("launch the openCart application")
	public void launch_the_openCart_application() throws IOException {
		launchApplication();
	}

	@Then("Read the cookies form {string}")
	public void read_the_cookies_form(String fileName) {
		//done in launch_the_openCart_application method
	}

	@Then("validate the home page")
	public void validate_the_home_page() {
		hmpg.validateHomePage();
	}

}

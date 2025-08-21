package stepDefination;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.navBar;
import pages.registrationPage;

public class registration {
	navBar nv = new navBar();
	registrationPage rst = new registrationPage();

    @When("I click on the {string} drop menu")
    public void i_click_on_the_drop_menu(String menu) {
    	nv.clickOnDropdown(menu);
    }

    @When("I click on the {string} option")
    public void i_click_on_the_option(String option) {
    	nv.clickOnOptionsInDrpDown(option);
    }

    @When("I enter the following mandatory account details:")
    public void i_enter_the_following_mandatory_account_details(Map<String, String> accountDetails) {
    	rst.enterFirstName(accountDetails.get("First Name"));
    	rst.enterLastName(accountDetails.get("Last Name"));
    	rst.enterEmail(accountDetails.get("E-Mail"));
    	rst.enterPassword(accountDetails.get("Password"));
    	
    	
 
    	
    	
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String button) {
    
    	rst.checkPrivecy();
    	rst.clickConfBtn();
    }

    @When("I click on the {string} button displayed on the {string} page")
    public void i_click_on_the_button_displayed_on_the_page(String button, String page) throws InterruptedException {
    	rst.clickConBtn_AccountSuccesPage();
    }

    @Then("I should be logged in and taken to the {string} page")
    public void i_should_be_logged_in_and_taken_to_the_page(String page) {
    	
    }


   
}


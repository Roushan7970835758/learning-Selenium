package MainSteps;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination {

@Given("User is on NetBanking landing page")
public void user_is_on_net_banking_landing_page() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("user loged in netBanking");
}
@When("^User login into application with (.+) and password (.+)$")
public void user_login_into_application_with_and_password(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("user loged in into application");
}


@Given("User is on Practice landing page")
public void user_is_on_practice_landing_page() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("user is on Practice page");
}
@When("User login into application")
public void user_login_into_application(List<String> data) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
	System.out.println("The data is: "+data.get(0));
	System.out.println("The data is: "+data.get(1));
	System.out.println("The data is: "+data.get(2));
	System.out.println("The data is: "+data.get(3));
	
}
@Then("Home page is displayed")
public void home_page_is_displayed() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("user loged in into home page");
}
@Then("Cards are displayed")
public void cards_are_displayed() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("user loged in card display");
}

@Given("setup the entires in database")
public void setup_the_entires_in_database() {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("***************************");
    System.out.println("setup the entries in data base");
}
@When("launch the browser from config variables")
public void launch_the_browser_from_config_variables() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("launch browser from config..");
}
@When("hit the home page url of banking site")
public void hit_the_home_page_url_of_banking_site() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("home page url should be reached");
}

}

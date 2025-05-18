package StepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;
import resources.TestDataBuild;
import resources.utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefenations extends utils {
	
	RequestSpecification res;
	ResponseSpecification resSpecBuilder;
	Response res2 ;
	TestDataBuild data = new TestDataBuild();
	
	 @Given("add place payload")
	    public void add_place_payload() {
	        // Create the request payload (modify with actual required fields)
			 res =given().spec(reqSpecBuilder)
			.body(data.addPlacePayload());
			 
			  
			
			
			System.out.println("process completed" );
	 }
	        

	    @When("user calls {string} with post http request")
	    public void user_calls_with_post_http_request(String apiName) {
	    	
	    	  res2 = res.when().post("maps/api/place/add/json").then()
	    				.spec(resSpecBuilder)
	    				.extract().response();
	    	 
	        
	    }

	    @Then("the API call got success with status code {int}")
	    public void verify_status_code(int expectedStatusCode) {
	    	assertEquals(res2.getStatusCode(),200);
	    	
	       
	    }
	    @And("{string} in response body is {string}")
	    public void verify_response_body_field(String KeyVlaue, String expectedValue) {
	    	String responseString = res2.asString();
	    	JsonPath js = new JsonPath(responseString);
	    	assertEquals(js.get(KeyVlaue).toString(),expectedValue);
			System.out.println("The response: "+responseString);
	    	
	    }

	    

}

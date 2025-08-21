package StepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.PendingException;
import org.junit.Assert;

import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
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
	
//	RequestSpecification reqSpec;
	RequestSpecification res;
	ResponseSpecification repSpec;
	ResponseSpecification resSpecBuilder;
	Response res2 ;
	TestDataBuild data = new TestDataBuild();
	JsonPath js;
	JsonPath js2;
    static String place_id;
	
	
	@Given("add place payload {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {
	    res = given().spec(requestSpecification())
	                 .body(data.addPlacePayload(name, language, address));
	    System.out.println("Process completed");
	}
	        
	    @When("user calls {string} with {string} http request")
	    public void user_calls_with_post_http_request(String apiName,String methodName) {
	    	
	    	APIResources apiMethod = APIResources.valueOf(apiName);
	    	
	    	if(methodName.equalsIgnoreCase("GET")){
	    		res2 = res.when().get(apiMethod.resource).then().log().all()
	    				.spec(responseSpecification())
	    				.extract().response();
	    	}else if(methodName.equalsIgnoreCase("POST")) {
	    		res2 = res.when().post(apiMethod.resource).then().log().all()
	    				.spec(responseSpecification())
	    				.extract().response();
	    	}else if(methodName.equalsIgnoreCase("DELETE")) {
	    		res2 = res.when().delete(apiMethod.resource).then().log().all()
	    				.spec(responseSpecification())
	    				.extract().response();
	    	}
	    	
	    	System.out.println("API response: "+res2.asString());

	    }

	    @Then("the API call got success with status code {int}")
	    public void verify_status_code(int expectedStatusCode) {
	    	assertEquals(res2.getStatusCode(),200);
	    }

	    @And("{string} in response body is {string}")
	    public void verify_response_body_field(String KeyVlaue, String expectedValue) {
	    	System.out.println("status of response is : "+getJsonPath(res2,KeyVlaue) );
	    	
	    	String responseString = getJsonPath(res2,KeyVlaue);
	    	
	    	 assertEquals(responseString,expectedValue);

	    }
	    
	    @Then("Varify placeId Created mapped to {string} using {string}")
	    public void varify_place_id_created_mapped_to_using(String expectedName, String string2) throws IOException {
	        // Write code here that turns the phrase above into concrete actions
	    	
	    	 place_id = getJsonPath(res2,"place_id");
	    	System.out.println(place_id);
	    	APIResources apiMethod = APIResources.valueOf(string2);
	    	
	    	res = given().spec(requestSpecification())
	    			.queryParam("place_id", place_id);
	    			
	    	user_calls_with_post_http_request( string2,"GET");
	        String name = getJsonPath(res2,"name");
	        Assert.assertEquals(expectedName, name);
	        
	    }


    @Given("Delete place Payload")
    public void deletePlacePayloadFun() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        res = given().spec(requestSpecification())
                .body(data.deletePlacePayload(place_id));
    }
}

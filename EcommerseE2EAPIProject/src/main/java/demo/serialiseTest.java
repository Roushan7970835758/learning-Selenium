package demo;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import POJOclasses.AddPlace;
import POJOclasses.Location;
public class serialiseTest {
	public static void main(String[] args) {
		
		
//		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		AddPlace p = new AddPlace();
		p.setName("Frontline house");
		p.setPhone_number("(+91) 983 893 3937");
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setWebsite( "https://rahulshettyacademy.com");
		p.setAccuracy(50);
		List<String> l1 = new ArrayList<>();
		l1.add("house");
		l1.add("Resedential");
		p.setTypes(l1);
		
		Location l = new Location();
		l.setLatitude(-38.383494);
		l.setLongitude(33.427362);
		
		p.setLocation(l);
		
		
		 RequestSpecification reqSpecBuilder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
		 ResponseSpecification resSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 
		 
		 RequestSpecification res =given().spec(reqSpecBuilder)
		.body(p);
		 
		  Response res2 = res.when().post("maps/api/place/add/json").then()
		.spec(resSpecBuilder)
		.extract().response();
		
		String responseString = res2.asString();
		System.out.println("The response: "+responseString);
		System.out.println("process completed" );
	}
}

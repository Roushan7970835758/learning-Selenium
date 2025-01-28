package demo;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import POJOclasses.AddPlace;
import POJOclasses.Location;
public class SpecBuilder {
	public static void main(String[] args) {
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
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
		
		
		
		Response res =given().log().all().queryParams("key","qaclick123")
		.body(p)
		.when().post("maps/api/place/add/json").then()
		.assertThat().statusCode(200)
		.extract().response();
		
		String responseString = res.asString();
		System.out.println("The response: "+responseString);
		System.out.println("process completed" );
	}
}

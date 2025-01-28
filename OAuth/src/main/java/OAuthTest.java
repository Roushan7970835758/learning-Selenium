import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.List;

import POJOclasses.Api;
import POJOclasses.GetCourseJava;

public class OAuthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String response = given()
		.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().log().all()
		.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
		.asString();
		
		System.out.println("the Post resp: "+response);
		
		JsonPath js = new JsonPath(response);
		String accesToken = js.getString("access_token");
		System.out.println("Access Token:  " +accesToken);
		
		//get method oauth
		GetCourseJava response2 = given()
				.queryParam("access_token", accesToken)
				.when().log().all()
				.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
				.as(GetCourseJava.class);
		System.out.println("Get response: "+response2.getLinkedIn() );
		
		List<Api> apiCourses = response2.getCourses().getApi();
		
		int totalCoursePrice =0;
		
		for(int i=0; i<apiCourses.size();i++) {
			if(apiCourses.get(i).getCourseTitle().equals("SoapUI Webservices testing")) {
				System.out.println("soupUi course price is : "+ apiCourses.get(i).getPrice());
				break;
			}
			
		}
		
		
		for(int i=0; i<apiCourses.size();i++) {
			
			totalCoursePrice+=Integer.parseInt(apiCourses.get(i).getPrice());
		}
		System.out.println("Total Price is: "+ totalCoursePrice);
		
				
		
		
		
	}

}

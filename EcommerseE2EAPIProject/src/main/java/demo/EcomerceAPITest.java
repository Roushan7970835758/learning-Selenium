package demo;

import POJOclasses.loginReasponse;
import POJOclasses.loginRequest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class EcomerceAPITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		
		loginRequest loginReq = new loginRequest();
		loginReq.setUserEmail("roushankumar22145@gmail.com");
		loginReq.setUserPassword("Roushan@123");
		
		RequestSpecification reqLogin = given().spec(req).body(loginReq);
		
		 loginReasponse resLogin = reqLogin.post("/api/ecom/auth/login").then().log().all().extract().response().as(loginReasponse.class);
		 
		 System.out.println("Token: "+ resLogin.getToken());
		 System.out.println("UserId: "+ resLogin.getUserId());
		
		
		
	}

}

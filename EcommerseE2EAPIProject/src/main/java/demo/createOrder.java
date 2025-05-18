package demo;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import POJOclasses.orderDetails;
import POJOclasses.orders;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class createOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 //create order
		 RequestSpecification reqToCrOdr = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				 .addHeader("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NzZlY2RmYmUyYjU0NDNiMWYwNWQyZGEiLCJ1c2VyRW1haWwiOiJyb3VzaGFua3VtYXIyMjE0NUBnbWFpbC5jb20iLCJ1c2VyTW9iaWxlIjoyMzQ1Njc4OTAxLCJ1c2VyUm9sZSI6ImN1c3RvbWVyIiwiaWF0IjoxNzM4ODY1MTA3LCJleHAiOjE3NzA0MjI3MDd9.ON-5DtuISzovFLUj2DD-MYZzMcUMzMCOqAdnmLMjhvU")
				 .setContentType(ContentType.JSON).build();
		 
		 orderDetails odrdtl = new orderDetails();
		 
		 odrdtl.setCountry("India");
		 odrdtl.setProductOrderedId("67a4fa66e2b5443b1f4ac44b");
		 
		 List<orderDetails> odrDtlList = new ArrayList<orderDetails>();
		 odrDtlList.add(odrdtl);
		 
		 orders odr = new orders();
		 odr.setOrders(odrDtlList);
		 
		 
		 RequestSpecification reqcrOdr = given().log().all().spec(reqToCrOdr).body(odr);
		  String resOrderCrt = reqcrOdr.post("/api/ecom/order/create-order").then().log().all().extract().response().asString();
		  System.out.println("response of Order created: " + resOrderCrt);

	}

}

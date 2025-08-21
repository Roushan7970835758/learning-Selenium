package practice_API_Automation.test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class test1 {
	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		RequestSpecification reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        // ✅ Response Spec
        ResponseSpecification resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .log(LogDetail.BODY)
                .build();
        
        Response res1 =given().spec(reqSpec).body(payLoad.addPlace()).post("/maps/api/place/add/json").then().spec(resSpec).extract().response();
		
        Response res2 = given().
						when().
						queryParam("key","qaclick123").
						header("Content-Type", "application/json").
						body(payLoad.addPlace()).
						post("/maps/api/place/add/json").then().log().all()
						.assertThat().statusCode(200)
						.extract().response();
	System.out.println(res1.asString());
	JsonPath jsp = new JsonPath(res1.asString());
	String placeId = jsp.getString("place_id");
	System.out.println(placeId);
	}

}

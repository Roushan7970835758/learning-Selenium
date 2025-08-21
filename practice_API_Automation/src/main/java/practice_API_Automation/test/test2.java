package practice_API_Automation.test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "http://216.10.245.166";
		Response res = given().
				when().
				body("{\r\n"
						+ "\r\n"
						+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
						+ "\"isbn\":\"bcd\",\r\n"
						+ "\"aisle\":\"227\",\r\n"
						+ "\"author\":\"John foe\"\r\n"
						+ "}\r\n"
						+ " \r\n"
						+ "").
				post("Library/Addbook.php").then().log().all().extract().response();
		
		System.out.println(res.asString());
		
		JsonPath js = new JsonPath(res.asString());
		String id = js.getString("ID");
		System.out.println(id);
		

	}

}

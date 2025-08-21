package practice_API_Automation.test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Oauth {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String res = given()
				.header("Content-Type", "application/x-www-form-urlencoded")
				.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParam("grant_type", "client_credentials")
				.formParam("scope", "trust").when().post("/oauthapi/oauth2/resourceOwner/token").then().log().all().assertThat().statusCode(200).extract().response().asString();

		

		String responseBody = res.toString();
		JsonPath js = new JsonPath(res);
		String accessToken = js.getString("access_token");
		System.out.println(accessToken);

		Response res2 = given().header("Content-Type", "application/json")
                .queryParam("access_token", accessToken)
        .when()
                .get("/oauthapi/getCourseDetails")
        .then()
                .log().all().assertThat().statusCode(401)
                .extract().response();

        System.out.println(res2.asString());

	}
}

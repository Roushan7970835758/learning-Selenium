package standAlone;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

//import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import resources.TestDataBuild;

public class standAloneTCs {
public static void main(String[] args) throws FileNotFoundException {
	
	PrintStream log = new PrintStream( new FileOutputStream("logging.txt"));
	TestDataBuild data = new TestDataBuild();
	
	
	RequestSpecification reqSpec = new RequestSpecBuilder()
			 .setBaseUri("https://rahulshettyacademy.com")
			 .addQueryParam("key", "qaclick123")
			 .addFilter(RequestLoggingFilter.logRequestTo(log))
			 .addFilter(ResponseLoggingFilter.logResponseTo(log))
			.setContentType(ContentType.JSON)
			.build();

    ResponseSpecification respSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    
    AddPlace p = data.addPlacePayload();
    System.out.println("Accurecy: "+p.getAccuracy()+"\n latitute: "+ p.getLocation().getLat());
    
    Response res = given().spec(reqSpec).body(p).when().post("maps/api/place/add/json").then()
			.spec(respSpec)
			.extract().response();
    
    String responseString = res.asString();
    System.out.println("The response: "+responseString);
    
    assertEquals(res.getStatusCode(),200);
    
    JsonPath js = new JsonPath(responseString);
	assertEquals(js.get("scope").toString(),"APP");
	
	System.out.println("Test Completed");
	
}
}

package resources;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class utils {
	public static RequestSpecification reqSpecBuilder;
	
 public RequestSpecification requestSpecification() throws IOException {
	 if(reqSpecBuilder == null) {
		 PrintStream log = new PrintStream( new FileOutputStream("logging.txt"));
		 
		 RestAssured.baseURI=getGlobalValue("url");
		 System.out.println("baseURL is: "+ getGlobalValue("url"));
		 
		 reqSpecBuilder =  new RequestSpecBuilder()
				 .setBaseUri(getGlobalValue("url"))
				 .addQueryParam("key", "qaclick123")
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON)
				.log(LogDetail.ALL)
				.build();
		 
		 return reqSpecBuilder;
	 }
	 return reqSpecBuilder;
	 
	 
	 
	
 }
 public ResponseSpecification responseSpecification() {
	 ResponseSpecification resSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	 
	 return resSpecBuilder;
 }
 
 public String getGlobalValue(String name) throws IOException {
	 Properties props = new Properties();
	 FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\global.properties");
	 props.load(fis);
	 return props.getProperty(name);
 }
 
 public String getJsonPath(Response res,String key) {
	 
	 String response = res.asString();
	 JsonPath js = new JsonPath(response);
	 return js.get(key).toString();
 }
}

package resources;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class utils {
	public RequestSpecification reqSpecBuilder;
 public RequestSpecification requestSpecification() throws FileNotFoundException {
	 PrintStream log = new PrintStream( new FileOutputStream("logging.txt"));
	 RestAssured.baseURI="https://rahulshettyacademy.com";
	 reqSpecBuilder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
			 .addFilter(RequestLoggingFilter.logRequestTo(log))
			 .addFilter(ResponseLoggingFilter.logResponseTo(log))
			.setContentType(ContentType.JSON).build();
	 
	 return reqSpecBuilder;
 }
}

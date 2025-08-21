package demo;

import POJOclasses.loginReasponse;
import POJOclasses.loginRequest;
import POJOclasses.orderDetails;
import POJOclasses.orders;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EcomerceAPITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();
		
		loginRequest loginReq = new loginRequest();
		loginReq.setUserEmail("roushankumar22145@gmail.com");
		loginReq.setUserPassword("Roushan@123");
		
		RequestSpecification reqLogin = given().spec(req).body(loginReq);
		
		 loginReasponse resLogin = reqLogin.post("/api/ecom/auth/login").then().extract().response().as(loginReasponse.class);
		 
		 System.out.println("Token: "+ resLogin.getToken());
		 System.out.println("UserId: "+ resLogin.getUserId());
		 
		 
		//create product
		 RequestSpecification   reqToAddProd = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				 .addHeader("Authorization",resLogin.getToken())
				 .build();
		 
		 RequestSpecification reqAddProd = given().spec(reqToAddProd)
		 .param("productName","Test_01")
		 .param("productAddedBy", resLogin.getUserId())
		 .param("productCategory", "Men")
		 .param("productSubCategory", "SuperMan")
		 .param("productPrice", "200000000")
		 .param("productDescription", "This is the strongest men")
		 .param("productFor","Gods")
		 .multiPart("productImage", new File("C://Users//User//Downloads//Photo_passport-Photoroom.png"));
		 
		 String addProdResp = reqAddProd.post("/api/ecom/product/add-product").then().log().all().extract().response().asString();
		 JsonPath js = new JsonPath(addProdResp);
		 String prodId = js.get("productId");
		 System.out.println(js.getString("message"));
		 
		 
		 
		 //create order
		 RequestSpecification reqToCrOdr = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				 .addHeader("Authorization",resLogin.getToken()).setContentType(ContentType.JSON).build();
		 
		 orderDetails odrdtl = new orderDetails();
		 
		 odrdtl.setCountry("India");
		 odrdtl.setProductOrderedId(prodId);
		 
		 List<orderDetails> odrDtlList = new ArrayList<orderDetails>();
		 odrDtlList.add(odrdtl);
		 
		 orders odr = new orders();
		 odr.setOrders(odrDtlList);
		 
		 
		 RequestSpecification reqcrOdr = given().spec(reqToCrOdr).body(odr);
		  String resOrderCrt = reqcrOdr.post("/api/ecom/order/create-order").then().log().all().extract().response().asString();
		  System.out.println("response of Order created: " + resOrderCrt);
		  
		  JsonPath js3 = new JsonPath(resOrderCrt);
		  
		  
		  List<String> orderscrId = js3.get("orders");	
		  String orderscrIdString = orderscrId.get(0);
		  
		  System.out.println("the order details are: " + orderscrIdString);
		  
		  
		  //delete product
		  RequestSpecification reqToDel = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
					 .addHeader("Authorization",resLogin.getToken()).setContentType(ContentType.JSON).build();
		  
		  RequestSpecification reqDel = given().spec(reqToDel).pathParam("productId", orderscrIdString);
		  
		  String delProdRes = reqDel.when().delete("/api/ecom/order/delete-order/{productId}")
				  .then().log().all().extract().response().asString();
		  JsonPath js1 = new JsonPath(delProdRes);
		 System.out.println("delete msg: "+ js1.get("message"));
		  
		  
		 
		 
		 
		
		
		
	}

}

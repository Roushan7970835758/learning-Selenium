package practice_API_Automation.test;

import io.restassured.path.json.JsonPath;

public class complexJsonParse {
	public static void main(String[] args) {
		JsonPath js = new JsonPath(payLoad.getCources());
		
		int getcount = js.getInt("courses.size()");
		int  totalamount = js.getInt("dashboard.purchaseAmount");
		int firstcoursePrice = js.getInt("courses[0].price");
		String firstcourseTitle = js.get("courses[0].title");
//		js.getString(firstcourseTitle)
		System.out.println(getcount+" "+ totalamount+" "+ firstcoursePrice+" "+firstcourseTitle);
	}
}

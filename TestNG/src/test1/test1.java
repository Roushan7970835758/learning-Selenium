package test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class test1 {

	@Test(groups={"smoke"})
	public void demo(){
		System.out.println("demo");
	}
	@Test(dataProvider="getData")
	public void temp(String username, String password) {
		System.out.println("temp");
		System.out.println(username);
		System.out.println(password);
	}
	@AfterSuite
	public void temp2() {
		System.out.print("After suite run");
	}
	@BeforeSuite
	public void temp3() {
		System.out.print("Before suite run");
	} 
	@Test
	public void temp4() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("opening google tab .... ");
	}
	@DataProvider
	public Object[][] getData() {
		//1st combination username password and cradit history
		//2nd username password no cradit history
		//3rd fraudinent and credit history
		
		Object[][] data = new Object[3][2];
		
		//1st set
		data[0][0] = "firstUsername";
		data[0][1] = "firstPassword";
		
		//2nd set
		data[1][0] ="secondUsername";
		data[1][1] ="secondPassword";
		
		//3rd set
		data[2][0] = "thirdUsername";
		data[2][1] = "third password";
		
		return data;
		
	}

}

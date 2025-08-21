package Test;

import org.testng.annotations.Test;

import BaseTest.baseTest;

public class testNgClass extends baseTest {


	@Test
	public void firstTest() {
		launchBrowser();
		System.out.println("This is my first test");
	}
}

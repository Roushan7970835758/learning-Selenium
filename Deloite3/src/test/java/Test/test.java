package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import AbstractComp.abstractClass;
import BaseTest.baseTest;

public class test extends abstractClass {
	public static void main(String[] args) throws IOException {
		public WebDriver driver;
		abstractClass abs = new abstractClass(driver);
		abs.lounchApplication();
	}

}

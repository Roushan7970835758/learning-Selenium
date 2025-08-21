package selenium.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;



public class baseTest {
	public static WebDriver driver;

	public String getGlobalProperties(String name) throws IOException {
		String path = System.getProperty("user.dir")+"src\\main\\java\\properties\\data.properties";
		Properties props = new Properties();
		
		FileInputStream fis = new FileInputStream(path);
		
		props.load(fis);
		
		 return props.getProperty(name);
		
	}
}

package BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {
	public static WebDriver driver;
	
	
	
	public String readProperty(String key) throws IOException {
		Properties props = new Properties();
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\Perty\\props.properties";
		
		FileInputStream fis = new FileInputStream(path);
		
		props.load(fis);
		return props.getProperty(key);
		
	}
	public String takeScreenshot(String name) throws IOException {
		TakesScreenshot ts =(TakesScreenshot) driver;
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\Screenshot\\" + name + ".png";
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File(path));
		
		return path;
		
		
		
	}
	
}

package MisculaniusTopics;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.github.com");
		
		LocalDateTime currDateTime = LocalDateTime.now();
		System.out.println(currDateTime);
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = "C:\\Users\\User\\Downloads\\screenshot.png";
		System.out.println(path);
		
		FileUtils.copyFile(src, new File(path));


	}

}

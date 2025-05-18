package Selenium.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Selenium.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {
	public WebDriver driver;
	public LandingPage l1;

	public WebDriver initBrowser() throws IOException {
		Properties props = new Properties();
//		FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\TODO\\SeleniumFrameworkDesign\\src\\main\\java\\Selenium\\resources\\GlobalData.properties");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\\\src\\\\main\\\\java\\\\Selenium\\\\resources\\\\GlobalData.properties");
		props.load(fis);
		String browserName = System.getProperty("Browser") != null ? System.getProperty("Browser")
				: props.getProperty("Browser");
		System.out.println("Browser name: " + browserName);

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			// Create ChromeOptions
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
//			options.addArguments("headless");
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edgedriver":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browserName);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		return driver;

	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		driver = initBrowser();
		l1 = new LandingPage(driver);
		l1.goTo();
		return l1;
	}
	
	@AfterMethod(alwaysRun = true)
	public void testTeardown() {
		driver.close();
	}
	
	public  List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(filePath),
				StandardCharsets.UTF_8);
	//string to Hashmap jakson databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
		
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		 if (driver == null) {
		        throw new RuntimeException("WebDriver instance is null. Cannot take screenshot.");
		    }
		    TakesScreenshot ts = (TakesScreenshot) driver;
		    File source = ts.getScreenshotAs(OutputType.FILE);
//		    String fileName = System.getProperty("user.dir") + "//reports//" + testCaseName + "_" + LocalDateTime.now().toString().replace(":", "-") + ".png";
		    String fileName = System.getProperty("user.dir") + "//reports//" + testCaseName + "_" + LocalDateTime.now().toString().replace(":", "-") + ".png";

		    FileUtils.copyFile(source, new File(fileName));
		    return fileName;
	}

}

package standAloneTCS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo1 {
	public WebDriver driver;
	@FindBy (xpath="//div[@id='search']//input")
	WebElement input_search;
	
	public Set<Cookie> allCookes;
	@Test
	public void  StoreCookies() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
        
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "localhost:" + "9222");
		// Initialize WebDriver
		 driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.opencart.com/");
		
		// Store cookies in a file
        File file = new File("cookie.data");
        file.delete(); // delete old file if exists
        file.createNewFile();
        
        System.out.println("cookie size: "+driver.manage().getCookies().size());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Cookie ck : driver.manage().getCookies()) {
                writer.write(
                        ck.getName() + ";" +
                        ck.getValue() + ";" +
                        ck.getDomain() + ";" +
                        ck.getPath() + ";" +
                        ck.getExpiry() + ";" +
                        ck.isSecure()
                );
                writer.newLine();
            }
        }

        System.out.println("Cookies saved to file.");
        driver.quit();
		
		
	}
	
	@Test
	public void orderProduct() throws FileNotFoundException, IOException {
		
		
		WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demo.opencart.com/"); // load page before adding cookies
        
        
     // Read cookies from file and add to driver
        try (BufferedReader reader = new BufferedReader(new FileReader("cookie.data"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String name = parts[0];
                String value = parts[1];
                String domain = parts[2];
                String path = parts[3];
                String expiry = parts[4];
                boolean isSecure = Boolean.parseBoolean(parts[5]);

                Cookie cookie = new Cookie.Builder(name, value)
                        .domain(domain)
                        .path(path)
                        .isSecure(isSecure)
                        .build();

                driver.manage().addCookie(cookie);
            }
        }
            
            driver.navigate().refresh();
		
            input_search.sendKeys("iPhone");
		driver.findElement(By.xpath("//div[@id='search']//input//following-sibling::button[@type='button']")).click();
		driver.findElement(By.xpath("//button[@data-bs-original-title='Add to Cart']")).click();
	}
	
	

}

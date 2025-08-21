package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test22 {

public static void main(String[] args) {
	// Explicitly set the driver version
    WebDriverManager.chromedriver().setup();

    
//    ChromeDriver driver = new ChromeDriver();    
    WebDriver driver = new ChromeDriver();
    
    //opening a url
    driver.get("https://www.youtube.com/feed/trending?bp=6gQJRkVleHBsb3Jl");
    
    driver.findElement(By.xpath("//div[@id=\"description-inner\"]//following::span[@style-target=\"bold\" and contains(.,\"views\")]")).click();
}
	
	
}

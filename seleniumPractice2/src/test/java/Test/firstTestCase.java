package Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstTestCase {
    public static void main(String[] args) throws InterruptedException {
        // Explicitly set the driver version
        WebDriverManager.chromedriver().setup();

        // Lonch chrome browser
//        ChromeDriver driver = new ChromeDriver();    
        WebDriver driver = new ChromeDriver();
        
        //opening a url
        driver.get("https://www.irctc.co.in/nget/train-search");
        
        //getting the title
        
        String str = driver.getTitle();
        
        if(str =="IRCTC Next Generation eTicketing System" ) {
        	System.out.println("Title Matched");
        }else {
        	System.out.println("Title does not Matched");
        	System.out.println(str);
        }
        
        driver.findElement(By.xpath("//strong[contains(text(),' KOLKATA RAJDHNI (12306)')]//ancestor::div[@class='form-group no-pad col-xs-12 bull-back border-all']")).click();
        
        //close Browser
        driver.close();
        

    }
}

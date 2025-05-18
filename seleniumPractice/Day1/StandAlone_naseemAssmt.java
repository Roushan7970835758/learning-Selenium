package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class StandAlone_naseemAssmt {
    public static void main(String[] args) {
        // Specify the debugging port (you must enable remote debugging when opening Chrome)
        String chromeDebuggingPort = "9222";  // Change this if needed

        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "localhost:" + chromeDebuggingPort);

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);
        
//        driver.findElement(By.xpath("//button[@name ='login']")).click();     //Primery info page 
        
        
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
     // Create WebDriverWait (explicit wait for 5 seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        // Now driver is attached to the existing browser session
        System.out.println("Attached to existing browser session");

        // Perform automation on the already opened page
        driver.getTitle();  // Just a check
        System.out.println(driver.getTitle());
       
        //start from biomatric information
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'TEK Employee Biographic Information ')]")));
        
        
        
     // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@name='EUS_prefix_10045']"));

        // Create a Select object
        Select dropdown = new Select(dropdownElement);

        // Select the second option by index (Index starts from 0, so 1 is the second option)
        dropdown.selectByIndex(1);
        
        driver.findElement(By.xpath("//input[@name='EUS_firstname_10045']")).sendKeys("Roushan");
        
        driver.findElement(By.xpath("//input[@name='EUS_lastname_10045']")).sendKeys("Kumar");
        
        WebElement country_dropdown = driver.findElement(By.xpath("//select[@name='EUS_countrycitizenship_10045']"));
        Select country_select = new Select(country_dropdown);
        country_select.selectByIndex(1);
        
        WebElement MargStatus_dropdown = driver.findElement(By.xpath("//select[@name='EUS_maritalstatus_10045']"));
        Select MargStatus_select = new Select(MargStatus_dropdown);
        MargStatus_select.selectByIndex(1);
        
        WebElement gender_dropdown = driver.findElement(By.xpath("//select[@name='EUS_gender_10045']"));
        Select gender_select = new Select(gender_dropdown);
        gender_select.selectByIndex(0);
        
        driver.findElement(By.xpath("//input[@name='EUS_streetaddress_10045']")).sendKeys("101 B NewTown Kolkata");
        driver.findElement(By.xpath("//input[@name='EUS_city_10045']")).sendKeys("Kolkata");
        driver.findElement(By.xpath("//input[@name='EUS_county_10045']")).sendKeys("India");
        driver.findElement(By.xpath("//input[@name='EUS_zip_10045']")).sendKeys("700156");
        
//        driver.findElement(By.xpath("//input[@name='EUS_mailingdifferent_10045']//parent::label//parent::div")).click(); 
        
        //using java Script 
        WebElement element = driver.findElement(By.xpath("(//input[@name='EUS_mailingdifferent_10045'])[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        
        WebElement HomeAdd_dropdown = driver.findElement(By.xpath("//select[@name='EUS_state_10045']"));
        Select HomeAdd_select = new Select(HomeAdd_dropdown);
        HomeAdd_select.selectByIndex(1);
        
        driver.findElement(By.xpath("//input[@name='EUS_emergcontact1firstname_10045']")).sendKeys("Roushan");
        driver.findElement(By.xpath("//input[@name='EUS_emergcontact1lastname_10045']")).sendKeys("Kumar");
        
        WebElement EmgCntRelShip_dropdown = driver.findElement(By.xpath("//select[@name='EUS_emergrelation1_10045']"));
        Select  EmgCntRelShip_select = new Select(EmgCntRelShip_dropdown);
        EmgCntRelShip_select.selectByIndex(1);
        
        driver.findElement(By.xpath("//input[@name='EUS_emergcontact1phone1_10045']")).sendKeys("7970835758");
        
        WebElement emgCntPhn_dropdown = driver.findElement(By.xpath("//select[@name='EUS_phonetype1_10045']"));
        Select emgCntPhn_select = new Select(emgCntPhn_dropdown);
        emgCntPhn_select.selectByIndex(1);
        
//        driver.findElement(By.xpath("(//input[@name='EUS_emerg1additional_10045'])[2]")).click();
        
        //using java Script 
        WebElement emerg1additional = driver.findElement(By.xpath("(//input[@name='EUS_emerg1additional_10045'])[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", emerg1additional);
        
//        driver.findElement(By.xpath("(//input[@name='EUS_addemergencycontact_10045'])[2]")).click();
      //using java Script 
        WebElement addemergencycontact = driver.findElement(By.xpath("(//input[@name='EUS_addemergencycontact_10045'])[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addemergencycontact);
        
        
//        driver.findElement(By.xpath("(//input[@name='EUS_paypreference_10045'])[2]")).click();
        
      //using java Script 
        WebElement paypreference = driver.findElement(By.xpath("(//input[@name='EUS_paypreference_10045'])[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", paypreference);
        
//        driver.findElement(By.xpath("//input[@name='EUS_authorizeelectronictax_10045']")).click();
        
        //using java Script 
        WebElement authorizeelectronictax = driver.findElement(By.xpath("//input[@name='EUS_authorizeelectronictax_10045']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", authorizeelectronictax);
        
        
        driver.findElement(By.id("onboarding-form-submit")).click();
        System.out.println("process Completed for from biomatric information ");
        
        //Esign form
        driver.findElement(By.name("login")).click();
    }
}





















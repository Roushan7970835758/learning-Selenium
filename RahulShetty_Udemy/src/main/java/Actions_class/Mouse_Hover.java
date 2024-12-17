package Actions_class;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse_Hover {
	public static void main(String[] args) throws InterruptedException {
	 
	 WebDriverManager.chromedriver().setup();
	 
	 WebDriver driver = new ChromeDriver();
	 
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 
	 driver.manage().window().maximize();
	 
	 driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=9700583295965939543&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9061819&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1");
	 
	 Actions a = new Actions(driver);
	 
//	 a.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();

	 a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("India").doubleClick().build().perform();
 
	}
}

package Selenium.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbstractComponenets.AbstractComponents;

public class productCatalog extends AbstractComponents {
	WebDriver driver;
	
	// Get the full product cards
    @FindBy(css = "div.mb-3")   
    public List<WebElement> prodList;
    
    @FindBy (xpath="//div[@id='toast-container']")
    public WebElement toastContainer;
    
    @FindBy (xpath ="//div[contains(@class,'ngx-spinner-overlay')]")
    public WebElement spinner;
    
    By products = By.cssSelector(".mb-3");
    
    

	
	public productCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getProdList() {
		waitForEleToAppear(products);
		for(WebElement em:prodList) {
			System.out.println("Product detail is: " + em.getText());
		}
		return prodList;
	}
	
	public WebElement getProdbyName(String name) throws InterruptedException {
		WebElement prod = null;
		for(WebElement s: getProdList()) {
//			String text = s.findElement(By.xpath("//b")).getText();
			String text = s.findElement(By.xpath(".//h5")).getText();
//			s.findElement(By.xpath("//b[text()='Roushan verma2']"));
			if(text.contains(name)) {
				prod=s;
				break;
			}
		}
		System.out.println("Product found: " + prod.getText());
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", prod);
		Thread.sleep(3000);
		return prod;
	}
	public void addProdToCart(String name) throws InterruptedException {
		WebElement prod = null;
		for(WebElement s: getProdList()) {
//			String text = s.findElement(By.xpath("//b")).getText();
			String text = s.findElement(By.xpath(".//h5")).getText();
//			s.findElement(By.xpath("//b[text()='Roushan verma2']"));
			if(text.contains(name)) {
				prod=s;
				System.out.println("Product found: " + prod.getText());
				break;
			}
		}

		if(prod == null)return;
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", prod);
		Thread.sleep(2000);
		prod.findElement(By.xpath(".//button[contains(text(),' Add To Cart')]")).click();
		
		waitForEleToDisApper(spinner);
		waitForEleToAppear(toastContainer);
		
		
	}
	
}

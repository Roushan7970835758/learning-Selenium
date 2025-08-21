package excelUploadDownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertEquals;

import io.github.bonigarcia.wdm.WebDriverManager;

public class excelReadWrite {
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String fruit_name = "Apple";
		int columnNum = 4;
		String price = "900";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//download the file 
		driver.findElement(By.id("downloadButton")).click();

		captureScreenshot(driver,"initial Data");
		Thread.sleep(2000);
		//edit the file
		updateExcel(fruit_name,columnNum,price);

		captureScreenshot(driver,"final Data");
		
		//upload the file
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\User\\Downloads\\download.xlsx");
		
		//varify uploading
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement alertPopup = driver.findElement(By.xpath("(//div[@class='Toastify__toast-body']//following::div)[1]"));
		w.until(ExpectedConditions.visibilityOf(alertPopup));
		
		String alertString = driver.findElement(By.xpath("(//div[@class='Toastify__toast-body']//following::div)[1]")).getText();
		
		assertEquals("Updated Excel Data Successfully.", alertString);
		
		w.until(ExpectedConditions.invisibilityOf(alertPopup));
		
		System.out.println(alertString);
		
		//print the updated data 
		String AppleData = driver.findElement(By.xpath("//div[text()='"+ fruit_name +"']//ancestor::div[@id='row-1']//div[@id='cell-"+columnNum+"-undefined']//div")).getText();
		
		assertEquals(AppleData, price);
		Thread.sleep(2000);
		driver.close();
		

	}
	
	 public static void updateExcel(String fruitName, int columnNum, String newValue) {
	        String filePath = "C:\\Users\\User\\Downloads\\download.xlsx";
			

	        try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = new XSSFWorkbook(fis)) {

	            Sheet sheet = workbook.getSheetAt(0);
	            boolean found = false;

	            for (Row row : sheet) {
	                Cell fruitCell = row.getCell(1); // column 1 is 'fruit_name'
	                if (fruitCell != null &&
	                    fruitCell.getCellType() == CellType.STRING &&
	                    fruitCell.getStringCellValue().equalsIgnoreCase(fruitName)) {

	                    Cell targetCell = row.getCell(columnNum-1);
	                    if (targetCell == null) {
	                        targetCell = row.createCell(columnNum-1);
	                    }

	                    System.out.println("Before Updata " + fruitName + " 350 ");
	                    targetCell.setCellValue(newValue);
						System.out.println("After update " + fruitName + " " + newValue);
	                    found = true;
	                    break;
	                }
	            }

	            if (!found) {
	                System.out.println(" Fruit name not found in Excel: " + fruitName);
	            }

	            // Write back the updated Excel
	            try (FileOutputStream fos = new FileOutputStream(filePath)) {
	                workbook.write(fos);
	                System.out.println("File updated successfully!");
	            }

	        } catch (IOException e) {
	            System.out.println(" Error during file update:");
	            e.printStackTrace();
	        }
	    }

	public static String captureScreenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\reports\\"+name+".png";

		 FileUtils.copyFile(source, new File(path));
		
		return path;
	}

	    

}

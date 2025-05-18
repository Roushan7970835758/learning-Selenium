package cucumber;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Selenium.resources.extentReporterNg;
import Selenium.testComponents.baseTest;

public class cucumberListeners2 extends baseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent = extentReporterNg.getReportObject();
	public  WebDriver driver;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	 @Override
	    public void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getMethod().getMethodName());
			extentTest.set(test); // unique test id errorValidationTest --> test
			
			System.out.println( " Starting test :" +result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        // Invoked when a test method succeeds
	    	test.log(Status.PASS, "Test Passed");
	        System.out.println("Test Passed: "+ result.getMethod().getMethodName());
	        
	        try {
	    		
				 driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
				 
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace(); 
			}
	   	
	   	//Screenshot,attach to report
	   	String FilePath = null;
	   	try {
	   		
				 FilePath = getScreenshot(result.getMethod().getMethodName(),driver);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   	extentTest.get().addScreenCaptureFromPath(FilePath, result.getMethod().getMethodName());

	    	
	    }
	    

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	System.out.println("Test failed: "+ result.getMethod().getMethodName());
	    	extentTest.get().fail(result.getThrowable());
	    	
	    	try {
	    		
				 driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
				 
				 System.out.println(driver);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("falls in exception: ");
				e.printStackTrace(); 
			}
	    	
	    	//Screenshot,attach to report
	    	String FilePath = null;
	    	try {
	    		
				 FilePath = getScreenshot(result.getMethod().getMethodName(),driver);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	extentTest.get().addScreenCaptureFromPath(FilePath, result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        // Invoked when a test method is skipped
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Invoked when a test method fails, but is within the success percentage
	    }

	    @Override
	    public void onTestFailedWithTimeout(ITestResult result) {
	        // Invoked when a test fails due to a timeout
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        // Invoked before any test methods of the current class are invoked
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        // Invoked after all test methods of the current class have run
	    	extent.flush();;
	    }
	
}
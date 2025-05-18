package Selenium.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReporterNg {
    public static ExtentReports extent;
	public static ExtentTest scenario;

    public static ExtentReports getReportObject() {
        if (extent == null) {
            String path = System.getProperty("user.dir") + "//reports1//index.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("Web Automation Result");
            reporter.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Roushan Kumar");
        }
        return extent;
    }
}

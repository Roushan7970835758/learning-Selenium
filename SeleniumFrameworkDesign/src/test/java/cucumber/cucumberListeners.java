package cucumber;

import Selenium.resources.extentReporterNg;
import Selenium.testComponents.baseTest;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class cucumberListeners extends baseTest implements EventListener {

    private static final Map<String, ExtentTest> scenarioTestMap = new HashMap<>();
    private static final ExtentReports extent = extentReporterNg.getReportObject();
    ExtentTest test;
	
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseStarted.class, this::handleTestCaseStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
        publisher.registerHandlerFor(TestCaseFinished.class, this::handleTestCaseFinished);
    }

    private void handleTestCaseStarted(TestCaseStarted event) {
        ExtentTest scenario = extent.createTest(event.getTestCase().getName());
        scenarioTestMap.put(event.getTestCase().getId().toString(), scenario);
    }

    private void handleTestStepFinished(TestStepFinished event) {
        TestStep step = event.getTestStep();

        if (!(step instanceof PickleStepTestStep)) {
            return;
        }

        PickleStepTestStep testStep = (PickleStepTestStep) step;
        String stepText = testStep.getStep().getKeyword() + testStep.getStep().getText();

        io.cucumber.plugin.event.Status cucumberStatus = event.getResult().getStatus();
        com.aventstack.extentreports.Status extentStatus;

        switch (cucumberStatus) {
            case PASSED:
                extentStatus = com.aventstack.extentreports.Status.PASS;
                break;
            case FAILED:
                extentStatus = com.aventstack.extentreports.Status.FAIL;
                break;
            case SKIPPED:
                extentStatus = com.aventstack.extentreports.Status.SKIP;
                break;
            default:
                extentStatus = com.aventstack.extentreports.Status.WARNING;
                break;
        }

        ExtentTest scenario = scenarioTestMap.get(event.getTestCase().getId().toString());

        if (extentStatus == com.aventstack.extentreports.Status.FAIL) {
            Throwable error = event.getResult().getError();
            scenario.log(extentStatus, stepText + " — FAILED");
            scenario.log(extentStatus, error);
        } else {
            scenario.log(extentStatus, stepText + " — " + cucumberStatus.name());
        }
        
      //Screenshot,attach to report
	   	String FilePath = null;
	   	try {
	   		
				 FilePath = getScreenshot(event.getTestCase().getName(),driver);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   	extentTest.get().addScreenCaptureFromPath(FilePath, event.getTestCase().getName());

    }

    private void handleTestCaseFinished(TestCaseFinished event) {
        extent.flush();
    }
}

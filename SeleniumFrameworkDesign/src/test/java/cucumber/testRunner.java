package cucumber;

import org.testng.annotations.Listeners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src\\test\\java\\cucumber",glue="Selenium.stepDefination",
monochrome=true ,tags="@Regression",
plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" })

public class testRunner extends AbstractTestNGCucumberTests {
	
}


//plugin= {"html:target/cucumber.html", "pretty" }
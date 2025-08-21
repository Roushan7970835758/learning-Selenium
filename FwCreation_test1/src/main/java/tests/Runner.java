package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features="src\\test\\java\\Feature",glue={"stepDefination"},    
		monochrome=true ,
		plugin= {"html:target/cucumber.html", "pretty" })
public class Runner extends AbstractTestNGCucumberTests {

	
}

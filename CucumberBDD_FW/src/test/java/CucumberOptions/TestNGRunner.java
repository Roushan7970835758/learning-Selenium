package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/firstProgram.feature", glue="MainSteps", monochrome= true,tags="@smokeTest",
plugin= {"pretty", "html:target/cucumber.html"})
public class TestNGRunner extends AbstractTestNGCucumberTests {


}

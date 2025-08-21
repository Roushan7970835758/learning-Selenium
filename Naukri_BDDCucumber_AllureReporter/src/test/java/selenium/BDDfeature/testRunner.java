package selenium.BDDfeature;



@cucumberOptions(feature="src\\test\\java\\selenium\\BDDfeature", glu="selenium.stepDefination",monochrome=true, 
plugin= {"html:target/cucumber.html", "pretty" })
public class testRunner extends AbstractTestNGCucumberTests {

	
	
}

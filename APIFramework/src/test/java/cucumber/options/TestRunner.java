package cucumber.options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/features",
    glue = {"StepDefination"},tags= "@deletePlace",
    monochrome = true,
    plugin = {"html:target/cucumber.html", "pretty"}
)
public class TestRunner {
}


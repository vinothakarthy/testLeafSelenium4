package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/Login.feature",glue="steps",publish=true)
public class Testrunner extends AbstractTestNGCucumberTests {

	
}

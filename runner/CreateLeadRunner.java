package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/CreateLead.feature",glue="steps",publish=true)
public class CreateLeadRunner extends AbstractTestNGCucumberTests {

}

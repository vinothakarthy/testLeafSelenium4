package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features",glue="steps",publish=true)
//tags="@regression or @smoke")
public class EditLeadRunner extends AbstractTestNGCucumberTests {

}

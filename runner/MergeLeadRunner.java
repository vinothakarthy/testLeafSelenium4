package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/MergeLead.feature",glue="steps",publish=true)
public class MergeLeadRunner extends AbstractTestNGCucumberTests{

}

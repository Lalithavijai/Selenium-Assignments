package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		dryRun=false,
		features= {"src/test/java/features/DeleteLead.feature"},
		glue= {"stepdefinition"},
		monochrome=true

			)
public class RunnerCucumberTests extends AbstractTestNGCucumberTests {

}

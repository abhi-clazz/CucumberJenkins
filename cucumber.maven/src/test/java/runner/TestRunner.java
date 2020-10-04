package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (features ={"src/test/resources/Features/Login.feature"},
glue = {"StepDefinition"},
dryRun=false, //To check running to find out did i miss any step
monochrome = true, // to make to console output in a better format 
strict=true,//it will check any steps in the feature file is missed in the implementation
plugin ={"html:testout/cucumber.html","junit:testout/cucumber.xml","json:testout/cucumber.json"}	
		)
public class TestRunner {

}
package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

public class Websiterunner {
	
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features= "/home/mounika/eclipse-workspace/Phptravelscucumber/src/main/java/Features/Websitelaunch.feature"
	       ,glue= {"Stepdefinitions"},
			dryRun = true
			,monochrome=false
	)
	public class Tarasritestrunner {
		
	}
	

}

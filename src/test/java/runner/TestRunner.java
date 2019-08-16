package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		 format = {"pretty","html:test-output"},
		 features="..\\CucumberTest\\src\\test\\java\\features\\Deal.feature",//path of the feature file
		 glue={"stepDefinition"},//path of the step definition file,
	     plugin={"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
		 dryRun=false// it will check the entire feature step in step definition
		,strict=true//it will run the application and check that all feature is implemented into step definition 
		,monochrome=true//Console output will pretty good format 
		//,tags={"@Deal"}
		
		
		)	


public class TestRunner 
{
	@AfterClass
	public static void teardown() {

		     Reporter.loadXMLConfig(new File("target/extent-config.xml"));
		     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
		     Reporter.setSystemInfo("Selenium", "3.7.0");
		     Reporter.setSystemInfo("Maven", "3.5.2");
		     Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}

}



package melon.APIBatch4CucumberProject.cuke.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features= {"src/test/resources/featureFiles"},
                 glue="melon.APIBatch4CucumberProject.cuke.steps",
                 plugin = {"pretty","html:reports/cucumber-html-report","json:reports/cucumber-reports/cucumber.json","junit:reports/cucumber-reports/cucumber.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class RunCuke extends AbstractTestNGCucumberTests {

}

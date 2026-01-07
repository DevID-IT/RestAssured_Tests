package CucumberBDD.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features= {"src/test/resources/features"},plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} ,glue="CucumberBDD.steps")
public class RunCuke extends AbstractTestNGCucumberTests{





}

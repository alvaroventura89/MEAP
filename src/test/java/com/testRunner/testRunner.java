package com.testRunner; 

import org.junit.AfterClass;

import org.junit.runner.RunWith;

import com.utils.BaseClass;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue =  {"com.testSteps", "com.utils","com.pages"} , monochrome = true, plugin = {"json:target/cucumber.json", "html:target/HtmlReports"},
dryRun=false)

public class testRunner {


}

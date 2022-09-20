package com.ui.w3s.runner;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"com.ui.w3s.steps"},
monochrome = true,
plugin ={"pretty","junit:target/JUnitReports/report.xml","json:target/JSONReports/report.json","html:target/HTMLReports"}
//tags="@smoketest"
)



public class TestRunner {



}
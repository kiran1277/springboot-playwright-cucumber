package nz.co.ats.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "nz.co.ats.steps,nz.co.ats.config")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, json:build/cucumber-reports/cucumber.json, html:build/cucumber-reports/cucumber-report.html")
public class TestRunner {
}

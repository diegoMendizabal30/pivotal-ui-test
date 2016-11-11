package org.fundacionjala.pivotal.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Class to execute all feature tests.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        format = {"pretty",
                "html:target/test-report",
                "json:target/test-report.json",
                "junit:target/test-report.xml"
        },
        features = {
                "src/test/resources/"
        },
        glue = {
                "org.fundacionjala.pivotal.cucumber"
        }
)
public class Runner {
}

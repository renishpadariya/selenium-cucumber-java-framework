package testrunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features",
    glue = {"stepdefinations", "apphooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-html-report.html",
        "json:target/cucumber.json"
    },
    monochrome = true
)
public class Testrunner {
}

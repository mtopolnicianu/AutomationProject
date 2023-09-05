package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@test",
        features = {"src/test/resources"},
        glue = {"steps"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class TestRunner {
}

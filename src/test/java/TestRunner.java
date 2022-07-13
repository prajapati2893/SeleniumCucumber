import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features/"},
        glue = {"stepDefinitions"},
        stepNotifications = true,
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty",
                "json:target/json-report/cucumber.json",
                "html:target/cucumberreport/cucumber.html",
                "junit:target/junit/junit.xml",
        }
)
//https://www.toolsqa.com/cucumber/cucumber-options/
public class TestRunner {
}

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        format = {
                "pretty",
                "json:target/cucumber-json-report.json",
                "junit:target/cucumber-junit.xml"},
        features = "src/main/resources/features",
        glue = {"steps"},
        tags = {"~@wip", "@google"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}

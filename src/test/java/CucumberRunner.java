import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = {"src/test/resources"},
        tags = "@asosSearch",
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/json-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun-reports/rerun.txt"
        }

)
@RunWith(cucumber.api.junit.Cucumber.class)
public class CucumberRunner
{


}
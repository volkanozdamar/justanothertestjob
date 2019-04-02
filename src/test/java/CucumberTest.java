import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(  features = "src/test/java/features")
public class CucumberTest extends AbstractTestNGCucumberTests
{
}
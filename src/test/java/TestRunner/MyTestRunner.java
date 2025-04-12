package TestRunner;

import Utilities.Retry;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

import org.testng.annotations.Test;


@CucumberOptions(
        features = "C:\\Users\\ragha\\SeleniumOrngHrm\\Selenium-Orange-HRM\\src\\test\\resources\\Features\\PIM.feature",
        glue = "StepDefinitions",
        tags = "@test2",
        plugin = {
                "pretty","html:target/cucumber-reports",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt" // Store failed scenarios again if needed
        }
)

public class MyTestRunner extends AbstractTestNGCucumberTests {

        @Test(
                groups = {"cucumber"},
                description = "Runs Cucumber Scenarios",
                dataProvider = "scenarios",
                retryAnalyzer = Retry.class
        )

        @Override
        public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
                super.runScenario(pickleWrapper, featureWrapper);
        }
   /* @Override
    @DataProvider(parallel = true)
   public Object[][] scenarios(){
        return super.scenarios();
    }*/
}
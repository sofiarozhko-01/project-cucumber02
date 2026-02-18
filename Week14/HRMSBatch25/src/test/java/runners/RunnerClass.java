package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //path of the feature directory
        features = "src/test/resources/features/",
        //path of the steps package, name must be same
        glue = "steps",
        //when you set the value of dry run to true, it stops execution and scans all the step def
        //and provide missing step definition, to execute the test case, set the value to false
        dryRun = true,
        //to execute test cases in a group, we need tagnames in feature file,
        // and we can use those tagnames here to execute the test cases in a group
        tags = "@add"
)

public class RunnerClass {}

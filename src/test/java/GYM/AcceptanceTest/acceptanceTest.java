package GYM.AcceptanceTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "cases",
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        glue = {"GYM.AcceptanceTest"}

)
public class acceptanceTest
{

}

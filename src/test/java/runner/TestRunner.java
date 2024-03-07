package test.java.runner;


import io.cucumber.testng.CucumberOptions;
import main.java.common.CucumberTestNGRunner;

@CucumberOptions(
        plugin={"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        features = "src/test/java/features",
        glue={"test.java.steps"}
)
public class TestRunner extends CucumberTestNGRunner {

    public static void main(){ }

}
package test.java.runner;


import io.cucumber.testng.CucumberOptions;
import main.java.common.CucumberTestNGRunner;

@CucumberOptions(
        plugin={"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        features = "src/test/java/features",
        glue={"test.java.steps"},
        tags = "not @ignore" //fast solution to skip (do not count) specified tests
)
public class TestRunner extends CucumberTestNGRunner {

    public static void main(){ }

}
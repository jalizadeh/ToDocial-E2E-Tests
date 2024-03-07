package test.java.runner;


import io.cucumber.testng.CucumberOptions;
import main.java.common.CucumberTestNGRunner;

@CucumberOptions(
        features = "src/test/java/features",
        glue={"test.java.steps"}
)
public class TestRunner extends CucumberTestNGRunner {

    public static void main(){ }

}
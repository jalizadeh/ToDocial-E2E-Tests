package main.java.steps;

import io.cucumber.java.en.Given;
import main.java.core.annotations.Flow;
import main.java.fe.flow.BrowserFlow;
import main.java.steps.technical.CucumberSteps;

public class BrowserSteps extends CucumberSteps {

    @Flow
    BrowserFlow browserFlow;

    @Given("user navigates to {string}")
    public void openPage(String page) {
        browserFlow.open(page);
    }

}

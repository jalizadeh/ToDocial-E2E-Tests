package main.java.steps;

import io.cucumber.java.en.Then;
import main.java.core.annotations.Flow;
import main.java.fe.flow.LogInPageFlow;
import main.java.steps.technical.CucumberSteps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LogInPageSteps extends CucumberSteps {

    @Flow
    LogInPageFlow logInPageFlow;

    @Then("user sees Sign In page header text equals to {string} on Login Page")
    public void verifySignInPageHeaderText(String expectedText) {
        assertThat(logInPageFlow.getSignInPageHeaderText()).isEqualTo(expectedText);
    }

}

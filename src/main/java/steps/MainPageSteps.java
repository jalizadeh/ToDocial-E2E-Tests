package main.java.steps;

import io.cucumber.java.en.Then;
import main.java.core.annotations.Flow;
import main.java.fe.flow.MainPageFlow;
import main.java.steps.technical.CucumberSteps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainPageSteps extends CucumberSteps {

    @Flow
    MainPageFlow mainPageFlow;

    @Then("user sees Sign Up email input on Main Page")
    public void verifySignUpEmailInput() {
        assertThat(mainPageFlow.isSignUpEmailFieldVisible()).isTrue();
    }

    @Then("user sees Sign Up button on Main Page")
    public void verifySignUpButton() {
        assertThat(mainPageFlow.isSignUpButtonVisible()).isTrue();
    }

}

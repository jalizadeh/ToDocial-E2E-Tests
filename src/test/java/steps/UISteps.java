package test.java.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.java.common.WebPage;
import main.java.manager.PageElementFinder;
import main.java.manager.SeleniumDriverManager;
import main.java.utils.Log;
import main.java.utils.SeleniumUtils;
import main.java.views.HomePage;
import main.java.views.LoginPage;
import main.java.views.NavMenu;
import org.junit.jupiter.api.Assumptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static main.java.manager.PageElementFinder.findPageElement;
import static main.java.utils.SeleniumUtils.*;
import static org.junit.jupiter.api.Assertions.*;

public class UISteps {

    private WebDriver driver;

    @Before
    public void setup(){
        SeleniumDriverManager.initDriver();
        driver = SeleniumDriverManager.getDriverInThreadLocal();
    }

    // custom tag to be used to intentionally skip feature or scenarios
    @Before("@ignore")
    public void skip_scenario(Scenario scenario){
        Assumptions.assumeTrue(false);
    }

    @After
    public void teardown(){
        SeleniumDriverManager.getDriverInThreadLocal().quit();
    }

    @Given("navigate to page {string}")
    public void navigateToPage(String url) {
        driver.get("http://localhost:8089/" + url);
    }


    @Then("check if has full access to top menu items")
    public void checkIfHasFullAccessToTopMenuItems() {
        new NavMenu()
                .checkIfTopMenuExistsForLoggedInUser()
                .checkIfFooterExists();
    }

    @Then("check top and bottom menu for anonymous user")
    public void checkTopAndBottomMenuForAnonymousUser() {
        new NavMenu()
                .checkIfTopMenuExistsForAnonymousUser()
                .checkIfFooterExists();
    }

    @Then("user logs out")
    public void userLogsOut() {
        new NavMenu()
                .logOut();
    }

    @Then("login fields are visible")
    public void loginFieldsAreVisible() {
        new LoginPage()
                .checkIfElementsExist();
    }

    @Then("{}.{} should be visible")
    public void shouldBeVisible(String page, String element) {
        pageElementShouldBeVisible(page, element);
    }

    @Then("{}.{} should not be visible")
    public void shouldNotBeVisible(String page, String element) {
        pageElementShouldNotBeVisible(page, element);
    }

    @When("click {}.{}")
    public void click(String page, String element) {
        clickPageElement(page, element);
    }

    @When("write {string} into {}.{}")
    public void writeText(String text, String page, String element) {
        writeTextIntoPageElement(page, element, text);
    }

    @Then("{}.{} has text {string}")
    public void hasText(String page, String element, String text) {
        pageElementHasText(page, element, text);
    }
}

package main.java.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.java.manager.SeleniumDriverManager;
import main.java.utils.SeleniumUtils;
import main.java.views.HomePage;
import main.java.views.LoginPage;
import org.openqa.selenium.WebDriver;

import static main.java.utils.SeleniumUtils.*;
import static org.junit.jupiter.api.Assertions.*;

public class UISteps {

    private WebDriver driver;

    @Before
    public void setup(){
        SeleniumDriverManager.initDriver();
        driver = SeleniumDriverManager.getDriverInThreadLocal();
    }

    @After
    public void teardown(){
        SeleniumDriverManager.getDriverInThreadLocal().quit();
    }

    @Given("navigate to homepage")
    public void navigateToPage() {
        driver.get("http://localhost:8089/");
    }

    @Given("navigate to page {string}")
    public void navigateToPage(String url) {
        driver.get("http://localhost:8089/" + url);
    }


    @When("fill username field with {string}")
    public void fillUsernameFieldWith(String username) {
        writeText(LoginPage.usernameInput, username);
    }

    @When("fill password field with {string}")
    public void fillPasswordFieldWith(String password) {
        writeText(LoginPage.passwordInput, password);
    }

    @When("click login button")
    public void clickLoginButton() {
        getElement(LoginPage.loginButton).click();
    }


    @Then("check if has full access to top menu items")
    public void checkIfHasFullAccessToTopMenuItems() {
        assertNotNull(getElement(HomePage.homeBtn));
        assertNotNull(getElement(HomePage.meButton));
        assertNotNull(getElement(HomePage.todoButton));
        assertNotNull(getElement(HomePage.gymButton));

        assertTrue(elementNotVisible(HomePage.loginLink));
        assertTrue(elementNotVisible(HomePage.signupLink));
    }

    @Then("check presence of alert box containing message {string}")
    public void checkPresenceOfAlertBoxContainingMessage(String msg) {
        assertNotNull(getElement(LoginPage.alertBox));
        assertEquals(msg, SeleniumUtils.getElement(LoginPage.alertBox).getText());
    }
}

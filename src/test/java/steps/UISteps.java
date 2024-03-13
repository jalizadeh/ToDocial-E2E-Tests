package test.java.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.java.common.WebPage;
import main.java.manager.SeleniumDriverManager;
import main.java.utils.Log;
import main.java.utils.SeleniumUtils;
import main.java.views.HomePage;
import main.java.views.LoginPage;
import main.java.views.NavMenu;
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
        new NavMenu()
                .checkIfTopMenuExistsForLoggedInUser()
                .checkIfFooterExists();
    }

    @Then("check presence of alert box containing message {string}")
    public void checkPresenceOfAlertBoxContainingMessage(String msg) {
        assertNotNull(getElement(LoginPage.alertBox));
        assertEquals(msg, SeleniumUtils.getElement(LoginPage.alertBox).getText());
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

    @Then("alert box should not be visible")
    public void alertBoxShouldNotBeVisible() {
        new LoginPage()
                .alertBoxVisibility(false);
    }
}

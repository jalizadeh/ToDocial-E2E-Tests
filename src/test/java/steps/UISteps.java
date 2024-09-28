package test.java.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.java.manager.SeleniumDriverManager;
import main.java.utils.DataProvider;
import main.java.views.HomePage;
import main.java.views.LoginPage;
import main.java.views.NavMenu;
import org.junit.jupiter.api.Assumptions;
import org.openqa.selenium.WebDriver;

import static main.java.utils.SeleniumUtils.*;

public class UISteps {

    private DataProvider dataProvider = DataProvider.getInstance();
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


    @Given("navigate to homepage")
    public void navigateToHomepage() {
        driver.get(dataProvider.homepage());
    }

    @Given("navigate to page {string}")
    public void navigateToPage(String page) {
        driver.get(dataProvider.page(page));
    }

    @Given("navigate to url {string}")
    public void navigateToUrl(String url) {
        driver.get(url);
    }


    @Then("user has {string} access to top menu items")
    public void userAccessToTopMenuItems(String accessType) {
        new NavMenu()
                .checkIfTopMenuExistsForLoggedInUser(accessType)
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

    @Then("community user {} with id {} is in the list")
    public void communityUserUserWithUsernameIsInTheList(String fullname, String username) {
        new HomePage().checkUser(fullname, username);
    }

    @Then("{}.{} size is {string} than {int}")
    public void homepageColumnRecentActivities_ItemsSizeIsThan(String page, String element, String operator, int value) {
        pageElementHasItems(page, element, operator, value);
    }
}
package main.java.steps.technical;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import main.java.core.TestContext;
import main.java.core.properties.PropertiesLoader;

@Slf4j
public class GlobalHooks extends CucumberSteps {

    @BeforeAll(order = 1)
    public static void loadProperties() {
        PropertiesLoader.getInstance().readAllProperties();
    }

    @Before
    public void restContext() {
        TestContext.resetContext();
    }

    @After(order = 5000)
    public void destroyDriver() {
        try {
            WebDriverRunner.closeWebDriver();
        } catch (Throwable exception) {
            log.info("There was an exception: {}", exception.getMessage());
        }
    }

    @After()
    public void performSoftAssert() {
        SoftAssertions assertions = TestContext.getContext(TestContext.ContextKeys.SOFT_ASSERT);
        assertions.assertAll();
    }

}

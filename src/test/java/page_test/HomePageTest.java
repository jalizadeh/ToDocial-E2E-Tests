package test.java.page_test;

import main.java.common.WebPageTest;
import main.java.views.HomePage;
import main.java.views.NavMenu;
import org.junit.jupiter.api.*;

@DisplayName("Homepage tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HomePageTest extends WebPageTest {

    @BeforeEach
    void beforeEach() {
        setup();
    }

    @AfterEach
    void afterEach() {
        teardown();
    }

    @Test
    @DisplayName("Top menu and footer for anonymous user")
    void HomepageTest_whenUserIsAnonymous_showBasicMenu() {
        new NavMenu()
                .checkIfTopMenuExistsForAnonymousUser()
                //.checkIfContentExist()
                .checkIfFooterExists();
    }


}

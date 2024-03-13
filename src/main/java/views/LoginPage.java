package main.java.views;

import main.java.common.WebPage;
import main.java.utils.SeleniumUtils;
import org.openqa.selenium.By;

import static main.java.utils.SeleniumUtils.*;
import static org.junit.jupiter.api.Assertions.*;


public class LoginPage extends WebPage {

    public final static By alertBox = By.xpath("//div[@role='alert']");

    public final static By usernameInput = By.xpath("//input[@id='username']");
    public final static By passwordInput = By.xpath("//input[@id='password']");
    public final static By loginButton = By.xpath("//button[@type='submit']");

    public LoginPage() {
        //driver.get(URL + "/login");
    }

    public LoginPage checkIfElementsExist(){
        assertNotNull(getElement(usernameInput));
        assertNotNull(getElement(passwordInput));
        assertNotNull(getElement(loginButton));
        return this;
    }

    public LoginPage fillFields(String username, String password){
        writeText(usernameInput, username);
        writeText(passwordInput, password);
        return this;
    }

    public LoginPage clickLoginButton(){
        getElement(loginButton).click();
        return this;
    }

    public LoginPage alertBoxHasMsg(String msg){
        assertEquals(msg, getElement(alertBox).getText());
        return this;
    }

    public LoginPage alertBoxVisibility(boolean shouldBeVisible) {
        if(shouldBeVisible)
            assertNotNull(getElement(alertBox));
        else
            assertTrue(elementNotVisible(alertBox));
        return this;
    }
}

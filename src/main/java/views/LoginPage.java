package main.java.views;

import main.java.common.WebPage;
import main.java.utils.SeleniumUtils;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class LoginPage extends WebPage {

    public final static By usernameInput = By.xpath("//input[@id='username']");
    public final static By passwordInput = By.xpath("//input[@id='password']");
    public final static By loginButton = By.xpath("//button[@type='submit']");

    public LoginPage() {
        driver.get(URL + "/login");
    }

    public LoginPage checkIfElementsExist(){
        assertNotNull(SeleniumUtils.getElement(usernameInput));
        assertNotNull(SeleniumUtils.getElement(passwordInput));
        assertNotNull(SeleniumUtils.getElement(loginButton));
        return this;
    }

    public LoginPage fillFields(String username, String password){
        SeleniumUtils.writeText(usernameInput, username);
        SeleniumUtils.writeText(passwordInput, password);
        return this;
    }

    public LoginPage clickLoginButton(){
        SeleniumUtils.getElement(loginButton).click();
        return this;
    }

    public LoginPage alertBoxHasMsg(String msg){
        assertEquals(msg, SeleniumUtils.getElement(alertBox).getText());
        return this;
    }
}

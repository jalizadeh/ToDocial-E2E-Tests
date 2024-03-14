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
    public final static By forgotPassLink = By.xpath("//a[@href='/forgot-password']");

    //Forgot Password Page
    public final static By fpEmailInput = By.xpath("//input[@id='email']");
    public final static By fpSubmitButton = loginButton;


    public LoginPage() {
        //driver.get(URL + "/login");
    }

    public LoginPage checkIfElementsExist(){
        shouldBeVisibleBy(usernameInput);
        shouldBeVisibleBy(passwordInput);
        shouldBeVisibleBy(loginButton);
        return this;
    }

    public LoginPage fillFields(String username, String password){
        writeText(usernameInput, username);
        writeText(passwordInput, password);
        return this;
    }

    public LoginPage clickLoginButton(){
        click(loginButton);
        return this;
    }

    public LoginPage alertBoxHasMsg(String msg){
        hasTextBy(alertBox, msg);
        return this;
    }

}

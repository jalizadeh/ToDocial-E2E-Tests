package main.java.common;

import main.java.manager.SeleniumDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Contains general components of a web page
 * Each page that is tested, should extend this class and focus only on it's components
 */
public class WebPage {

    protected final String URL = "http://localhost:8089";
    protected WebDriver driver;

    protected final By alertBox = By.xpath("//div[@class='alert alert-danger']");


    public WebPage(){
        this.driver = SeleniumDriverManager.getDriverInThreadLocal();
    }

}

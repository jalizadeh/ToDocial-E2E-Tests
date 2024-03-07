package main.java.common;

import main.java.manager.SeleniumDriverManager;
import org.openqa.selenium.WebDriver;

public class WebPageTest {

    protected WebDriver driver;

    protected void setup(){
        SeleniumDriverManager.initDriver();
    }

    protected  void teardown(){
        SeleniumDriverManager.getDriverInThreadLocal().quit();
    }

}

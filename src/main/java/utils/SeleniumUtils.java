package main.java.utils;

import main.java.manager.SeleniumDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static main.java.manager.PageElementFinder.findPageElement;
import static org.junit.jupiter.api.Assertions.*;

public class SeleniumUtils {

    private static final int TIMEOUT_WAIT = 20; // in seconds
    private static final int TIMEOUT_POLLING = 250; // in milliseconds


    public static void refreshPage(){
        SeleniumDriverManager.getDriverInThreadLocal().navigate().refresh();
    }

    public static void clickPageElement(String page, String element){
        getPageElement(page, element).click();
    }

    public static void click(By by){
        assertNotNull(getElementBy(by));
        getElementBy(by).click();
    }

    public static void writeText(By by, String text) {
        WebElement element = getElementBy(by);
        element.clear();
        element.sendKeys(text);
    }

    public static void writeTextIntoPageElement(String page, String element, String text) {
        WebElement pageElement = getPageElement(page, element);
        pageElement.clear();
        pageElement.sendKeys(text);
    }

    public static void pageElementHasText(String page, String element, String text) {
        WebElement pageElement = getPageElement(page, element);
        assertEquals(pageElement.getText(), text);
    }

    public static void pageElementShouldBeVisible(String page, String element) {
        assertNotNull(getPageElement(page, element));
    }

    public static void pageElementShouldNotBeVisible(String page, String element) {
        assertTrue(elementNotVisible(findPageElement(page, element)));
    }

    public static WebElement getPageElement(String page, String element){
        return getElementBy(findPageElement(page, element));
    }
    
    public static WebElement getElementBy(By by) {
        return waitForElement(by);
    }

    public static WebElement waitForElement(By by) {
        FluentWait<WebDriver> fw = new FluentWait<>(SeleniumDriverManager.getDriverInThreadLocal())
                .withTimeout(Duration.ofSeconds(TIMEOUT_WAIT))
                .pollingEvery(Duration.ofMillis(TIMEOUT_POLLING))
                .ignoring(NoSuchElementException.class);
        return fw.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static boolean elementNotVisible(By element) {
        try {
            waitForNotVisibleElement(element);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public static void waitForNotVisibleElement(By by) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(
                SeleniumDriverManager.getDriverInThreadLocal())
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

}

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
import java.util.List;

import static main.java.manager.PageElementFinder.findPageElement;
import static org.junit.jupiter.api.Assertions.*;

public class SeleniumUtils {

    private static final int TIMEOUT_WAIT = 10; // in seconds
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
        assertEquals(text, pageElement.getText());
    }

    public static void pageElementHasItems(String page, String element, String operator, int value) {
        List<WebElement> pageElements = getPageElements(page, element);
        switch (operator){
            case "more":
                assertTrue(pageElements.size() >= value);
                break;
            case "less":
                assertTrue(pageElements.size() <= value);
            default:
                throw new IllegalArgumentException("The operator: '" + operator + "' is not defined");
        }
    }

    public static void hasTextBy(By element, String text) {
        WebElement pageElement = getElementBy(element);
        assertEquals(text, pageElement.getText());
    }

    public static void pageElementShouldBeVisible(String page, String element) {
        assertNotNull(getPageElement(page, element));
    }

    public static void shouldBeVisibleBy(By element) {
        assertNotNull(getElementBy(element));
    }

    public static void pageElementShouldNotBeVisible(String page, String element) {
        assertTrue(elementNotVisible(findPageElement(page, element)));
    }

    public static void shouldNotBeVisibleBy(By element) {
        assertTrue(elementNotVisible(element));
    }

    public static WebElement getPageElement(String page, String element){
        return getElementBy(findPageElement(page, element));
    }

    public static List<WebElement> getPageElements(String page, String element){
        return getElementsBy(findPageElement(page, element));
    }
    
    public static WebElement getElementBy(By by) {
        return waitForElement(by);
    }
    public static List<WebElement> getElementsBy(By by) {
        return waitForElements(by);
    }

    public static WebElement waitForElement(By by) {
        FluentWait<WebDriver> fw = new FluentWait<>(SeleniumDriverManager.getDriverInThreadLocal())
                .withTimeout(Duration.ofSeconds(TIMEOUT_WAIT))
                .pollingEvery(Duration.ofMillis(TIMEOUT_POLLING))
                .ignoring(NoSuchElementException.class);
        return fw.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static List<WebElement> waitForElements(By by) {
        FluentWait<WebDriver> fw = new FluentWait<>(SeleniumDriverManager.getDriverInThreadLocal())
                .withTimeout(Duration.ofSeconds(TIMEOUT_WAIT))
                .pollingEvery(Duration.ofMillis(TIMEOUT_POLLING))
                .ignoring(NoSuchElementException.class);
        return fw.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
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
                .withTimeout(Duration.ofSeconds(TIMEOUT_WAIT))
                .pollingEvery(Duration.ofMillis(TIMEOUT_POLLING))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

}

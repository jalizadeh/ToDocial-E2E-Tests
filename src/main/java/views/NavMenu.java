package main.java.views;

import io.cucumber.java.en.Then;
import main.java.common.WebPage;
import main.java.utils.SeleniumUtils;
import org.openqa.selenium.By;

import static main.java.utils.SeleniumUtils.*;
import static org.junit.jupiter.api.Assertions.*;

public class NavMenu extends WebPage {

    //top menu
    public final static By homeBtn = By.xpath("//a[@class='navbar-brand' and @href='/']");
    public final static By loginLink = By.xpath("//a[@class='nav-link' and @href='/login']");
    public final static By signupLink = By.xpath("//a[@class='nav-link' and @href='/signup']");

    // top menu - logged in user
    public final static By meButton = By.xpath("//a[@class='navbar-brand' and @href='/me']");
    public final static By todoButton = By.xpath("//a[@class='navbar-brand' and @href='/todos']");
    public final static By gymButton = By.xpath("//a[@class='navbar-brand' and @href='/gym']");
    public final static By searchForm = By.xpath("//form[@id='searchForm']");
    public final static By navItemTodos = By.xpath("//li[@id='navItemTodos']");
    public final static By navItemGym = By.xpath("//li[@id='navItemGym']");
    public final static By navItemDiary = By.xpath("//li[@id='navItemDiary']");
    public final static By navItemPLCT = By.xpath("//li[@id='navItemPLCT']");
    public final static By navItemCalendar = By.xpath("//li[@id='navItemCalendar']");
    public final static By navItemExperience = By.xpath("//li[@id='navItemExperience']");
    public final static By navItemShop = By.xpath("//li[@id='navItemShop']");

    public final static By navItemUser = By.xpath("//li[@id='navItemUser']");
    public final static By navItemUser_LogoutBtn = By.xpath("//li[@id='navItemUser']//a[@href='/logout']");


    public final static By navItemSettings = By.xpath("//li[@id='navItemSettings']");


    //footer
    public final static By footer = By.xpath("//footer[@id='sticky-footer']");
    public final static By footer_copyright = By.xpath("//div[@id='footer-copyright']");
    public final static By footer_language = By.xpath("//div[@id='footer-language']");
    public final static By footer_language_en = By.xpath("//a[@id='langEN']");
    public final static By footer_language_it = By.xpath("//a[@id='langEN']");

    public NavMenu() {
        //driver.get(URL);
    }

    public NavMenu checkIfTopMenuExistsForAnonymousUser() {
        assertNotNull(getElementBy(homeBtn));
        assertNotNull(getElementBy(loginLink));
        assertNotNull(getElementBy(signupLink));
        return this;
    }

    public NavMenu checkIfTopMenuExistsForLoggedInUser() {
        assertTrue(elementNotVisible(loginLink));
        assertTrue(elementNotVisible(signupLink));

        assertNotNull(getElementBy(homeBtn));
        assertNotNull(getElementBy(meButton));
        assertNotNull(getElementBy(todoButton));
        assertNotNull(getElementBy(gymButton));
        assertNotNull(getElementBy(searchForm));
        assertNotNull(getElementBy(navItemTodos));
        assertNotNull(getElementBy(navItemGym));
        assertNotNull(getElementBy(navItemDiary));
        assertNotNull(getElementBy(navItemPLCT));
        assertNotNull(getElementBy(navItemCalendar));
        assertNotNull(getElementBy(navItemExperience));
        assertNotNull(getElementBy(navItemShop));
        assertNotNull(getElementBy(navItemUser));
        assertNotNull(getElementBy(navItemSettings));
        return this;
    }

    public NavMenu checkIfFooterExists() {
        assertNotNull(getElementBy(footer));
        assertEquals("© 2020-2024 ToDocial", getElementBy(footer_copyright).getText());
        assertNotNull(getElementBy(footer_language));
        assertNotNull(getElementBy(footer_language_en));
        assertNotNull(getElementBy(footer_language_it));
        return this;
    }

    public NavMenu logOut() {
        click(navItemUser);
        click(navItemUser_LogoutBtn);
        return this;
    }
}

package main.java.views;

import main.java.common.WebPage;
import org.openqa.selenium.By;

import static main.java.utils.SeleniumUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        shouldBeVisibleBy(homeBtn);
        shouldBeVisibleBy(loginLink);
        shouldBeVisibleBy(signupLink);
        return this;
    }

    public NavMenu checkIfTopMenuExistsForLoggedInUser(String accessType) {
        shouldNotBeVisibleBy(loginLink);
        shouldNotBeVisibleBy(signupLink);

        shouldBeVisibleBy(homeBtn);
        shouldBeVisibleBy(meButton);
        shouldBeVisibleBy(todoButton);
        shouldBeVisibleBy(gymButton);
        shouldBeVisibleBy(searchForm);
        shouldBeVisibleBy(navItemTodos);
        shouldBeVisibleBy(navItemGym);
        shouldBeVisibleBy(navItemDiary);
        shouldBeVisibleBy(navItemPLCT);
        shouldBeVisibleBy(navItemCalendar);
        shouldBeVisibleBy(navItemExperience);
        shouldBeVisibleBy(navItemShop);
        shouldBeVisibleBy(navItemUser);

        if(accessType.equals("admin"))
            shouldBeVisibleBy(navItemSettings);

        return this;
    }

    public NavMenu checkIfFooterExists() {
        shouldBeVisibleBy(footer);
        hasTextBy(footer_copyright, "© 2020-2024 ToDocial");
        shouldBeVisibleBy(footer_language);
        shouldBeVisibleBy(footer_language_en);
        shouldBeVisibleBy(footer_language_it);
        return this;
    }

    public NavMenu logOut() {
        click(navItemUser);
        click(navItemUser_LogoutBtn);
        return this;
    }
}

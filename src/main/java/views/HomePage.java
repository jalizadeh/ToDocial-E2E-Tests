package main.java.views;

import main.java.common.WebPage;
import main.java.utils.SeleniumUtils;
import org.openqa.selenium.By;

import static main.java.utils.SeleniumUtils.hasTextBy;
import static main.java.utils.SeleniumUtils.shouldBeVisibleBy;
import static org.junit.jupiter.api.Assertions.*;

public class HomePage extends WebPage {

    public final static By columnCommunity = By.id("col-community");
    public final static By columnRecentActivities = By.id("col-recent-activities");

    public void checkUser(String fullname, String username) {
        By userImg = By.xpath("//div[@id='col-community']//a[@href='/@" + username + "'][1]//img");
        By userLink = By.xpath("//div[@id='col-community']//a[@href='/@" + username + "'][2]");
        shouldBeVisibleBy(userImg);
        hasTextBy(userLink, fullname);
    }
}

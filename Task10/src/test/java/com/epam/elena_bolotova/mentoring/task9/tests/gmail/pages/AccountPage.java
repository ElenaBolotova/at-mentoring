package com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages;

import com.epam.elena_bolotova.mentoring.task9.framework.core.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {
    private final By logOutLinkLocator = By.xpath("//a[contains(@href, 'Logout')]");

    public void signOut() {
        waitForElementPresent(logOutLinkLocator);
        Driver.getDriverInstance().findElement(logOutLinkLocator).click();
    }
}

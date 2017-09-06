package com.epam.elena_bolotova.mentoring.task6.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {
    private final By logOutLinkLocator = By.xpath("//a[contains(@href, 'Logout')]");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void singOut() {
        waitForElementPresent(logOutLinkLocator);
        driver.findElement(logOutLinkLocator).click();
    }
}

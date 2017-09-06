package com.epam.elena_bolotova.mentoring.task6.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {
    @FindBy (xpath = "//a[contains(@href, 'Logout')]")
    private WebElement logOutLinkLocator;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void singOut() {
        waitForElementVisible(logOutLinkLocator);
        logOutLinkLocator.click();
    }
}

package com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages;

import com.epam.elena_bolotova.mentoring.task9.framework.core.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    private final By composeButtonLocator = By.xpath("//div[contains(@role, 'button') and contains(text(),'COMPOSE')]");
    private final By draftsLinkLocator = By.partialLinkText("Drafts");
    private final By sentMailLinkLocator = By.partialLinkText("Sent Mail");
    private final By accountLinkLocator = By.xpath("//a[contains(@href, 'SignOut')]");
    private final By draftDiscardMessageLocator = By.xpath("//span[contains(text(), 'Your message has been discarded.')]");

    public DraftPage composeDraft(){
        waitForElementVisible(composeButtonLocator);
        Driver.getDriverInstance().findElement(composeButtonLocator).click();
        return new DraftPage();
    }

    public DraftsPage openDraftsFolder(){
        waitForElementVisible(draftsLinkLocator);
        Driver.getDriverInstance().findElement(draftsLinkLocator).click();
        return new DraftsPage();
    }

    public SentMailPage openSentMailFolder(){
        waitForElementVisible(sentMailLinkLocator);
        Driver.getDriverInstance().findElement(sentMailLinkLocator).click();
        return new SentMailPage();
    }

    public AccountPage openAccountPage(){
        waitForElementVisible(accountLinkLocator);
        Driver.getDriverInstance().findElement(accountLinkLocator).click();
        return new AccountPage();
    }

    public String getDraftDiscardMessage(){
        waitForElementVisible(draftDiscardMessageLocator);
        return Driver.getDriverInstance().findElement(draftDiscardMessageLocator).getText();
    }
}

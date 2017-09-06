package com.epam.elena_bolotova.mentoring.task6.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    private final By composeButtonLocator = By.xpath("//div[contains(@role, 'button') and contains(text(),'COMPOSE')]");
    private final By draftsLinkLocator = By.partialLinkText("Drafts");
    private final By sentMailLinkLocator = By.partialLinkText("Sent Mail");
    private final By accountLinkLocator = By.xpath("//a[contains(@href, 'SignOut')]");
    private final By draftDiscardMessageLocator = By.xpath("//span[contains(text(), 'Your message has been discarded.')]");

    public MainPage(WebDriver driver){
        super(driver);
    }

    public DraftPage composeDraft(){
        waitForElementVisible(composeButtonLocator);
        driver.findElement(composeButtonLocator).click();
        return new DraftPage(driver);
    }

    public DraftsPage openDraftsFolder(){
        waitForElementVisible(draftsLinkLocator);
        driver.findElement(draftsLinkLocator).click();
        return new DraftsPage(driver);
    }

    public SentMailPage openSentMailFolder(){
        waitForElementVisible(sentMailLinkLocator);
        driver.findElement(sentMailLinkLocator).click();
        return new SentMailPage(driver);
    }

    public AccountPage openAccountPage(){
        waitForElementVisible(accountLinkLocator);
        driver.findElement(accountLinkLocator).click();
        return new AccountPage(driver);
    }

    public String getDraftDiscardMessage(){
        waitForElementVisible(draftDiscardMessageLocator);
        return driver.findElement(draftDiscardMessageLocator).getText();
    }
}

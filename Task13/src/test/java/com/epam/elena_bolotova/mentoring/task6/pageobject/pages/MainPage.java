package com.epam.elena_bolotova.mentoring.task6.pageobject.pages;

import com.epam.elena_bolotova.mentoring.task6.pageobject.reporting.MyLogger;
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
        MyLogger.info("Creting n");
        return new DraftPage(driver);
    }

    public DraftsPage openDraftsFolder(){
        waitForElementVisible(draftsLinkLocator);
        driver.findElement(draftsLinkLocator).click();
        MyLogger.info("Opening Drafts folder");
        return new DraftsPage(driver);
    }

    public SentMailPage openSentMailFolder(){
        waitForElementVisible(sentMailLinkLocator);
        driver.findElement(sentMailLinkLocator).click();
        MyLogger.info("Opening Sent Mail folder");
        return new SentMailPage(driver);
    }

    public AccountPage openAccountPage(){
        waitForElementVisible(accountLinkLocator);
        driver.findElement(accountLinkLocator).click();
        MyLogger.info("Opening Account page");
        return new AccountPage(driver);
    }

    public String getDraftDiscardMessage(){
        waitForElementVisible(draftDiscardMessageLocator);
        MyLogger.info("Checking message draft is discard");
        return driver.findElement(draftDiscardMessageLocator).getText();
    }
}

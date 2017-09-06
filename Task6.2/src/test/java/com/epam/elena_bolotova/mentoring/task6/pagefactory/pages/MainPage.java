package com.epam.elena_bolotova.mentoring.task6.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{

    @FindBy (xpath = "//div[contains(@role, 'button') and contains(text(),'COMPOSE')]")
    private WebElement composeButtonLocator;

    @FindBy (partialLinkText = "Drafts")
    private WebElement draftsLinkLocator;

    @FindBy (partialLinkText = "Sent Mail")
    private WebElement sentMailLinkLocator;

    @FindBy (xpath = "//a[contains(@href, 'SignOut')]")
    private WebElement accountLinkLocator;

    @FindBy (xpath = "//span[contains(text(), 'Your message has been discarded.')]")
    private WebElement draftDiscardMessageLocator;

    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public DraftPage composeDraft(){
        waitForElementVisible(composeButtonLocator);
        composeButtonLocator.click();
        return new DraftPage(driver);
    }

    public DraftsPage openDraftsFolder(){
        waitForElementVisible(draftsLinkLocator);
        draftsLinkLocator.click();
        return new DraftsPage(driver);
    }

    public SentMailPage openSentMailFolder(){
        waitForElementVisible(sentMailLinkLocator);
        sentMailLinkLocator.click();
        return new SentMailPage(driver);
    }

    public AccountPage openAccountPage(){
        waitForElementVisible(accountLinkLocator);
        accountLinkLocator.click();
        return new AccountPage(driver);
    }

    public String getDraftDiscardMessage(){
        waitForElementVisible(draftDiscardMessageLocator);
        return draftDiscardMessageLocator.getText();
    }
}

package com.epam.elena_bolotova.mentoring.task6.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftsPage extends BasePage {

    @FindBy (xpath = "//table//span[.='Test email']")
    private WebElement draftMessageLocator;

    @FindBy (xpath = "//td[contains(text(),\"You don't have any saved drafts.\")]")
    private WebElement noDraftMessagesLocator;


    public DraftsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean isDraftMessageExists(){
        return isElementExists(draftMessageLocator);
    }

    public boolean isDraftsFolderEmpty(){
        waitForElementVisible(noDraftMessagesLocator);
        return noDraftMessagesLocator !=null;
    }

    public DraftPage openDraftMessage(){
        waitForElementVisible(draftMessageLocator);
        draftMessageLocator.click();
        return new DraftPage(driver);
    }
}

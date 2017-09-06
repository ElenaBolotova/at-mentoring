package com.epam.elena_bolotova.mentoring.task6.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DraftsPage extends BasePage {

    private final By draftMessageLocator = By.xpath("//table//span[.='Test email']");
    private final By noDraftMessagesLocator = By.xpath("//td[contains(text(),\"You don't have any saved drafts.\")]");

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDraftMessageExists(){
        return isElementExists(draftMessageLocator);
    }

    public boolean isDraftsFolderEmpty(){
        waitForElementPresent(noDraftMessagesLocator);
        return driver.findElement(noDraftMessagesLocator) != null;
    }

    public DraftPage openDraftMessage(){
        waitForElementVisible(draftMessageLocator);
        driver.findElement(draftMessageLocator).click();
        return new DraftPage(driver);
    }
}

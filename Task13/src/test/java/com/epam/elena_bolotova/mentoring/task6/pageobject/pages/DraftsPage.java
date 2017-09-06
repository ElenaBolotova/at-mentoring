package com.epam.elena_bolotova.mentoring.task6.pageobject.pages;

import com.epam.elena_bolotova.mentoring.task6.pageobject.reporting.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DraftsPage extends BasePage {

    private final By draftMessageLocator = By.xpath("//table//span[.='Test email']");
    private final By noDraftMessagesLocator = By.xpath("//td[contains(text(),\"You don't have any saved drafts.\")]");
    private final By inboxLinkLocator = By.partialLinkText("Inbox");
    private final By alertLocator = By.xpath("//div[contains(@role, 'alert')]//span[contains(text(),'The message has been moved to the Inbox.')]\n");

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDraftMessageExists()
    {
        MyLogger.info("Checking draft existence");
        return isElementExists(draftMessageLocator);
    }

    public boolean isDraftsFolderEmpty(){
        waitForElementPresent(noDraftMessagesLocator);
        MyLogger.info("Checking if Drafts folder is empty");
        return driver.findElement(noDraftMessagesLocator) != null;
    }

    public DraftPage openDraftMessage(){
        waitForElementVisible(draftMessageLocator);
        driver.findElement(draftMessageLocator).click();
        MyLogger.info("Opening draft message");
        return new DraftPage(driver);
    }

    public DraftPage openDraftMessageByKeys(){
        waitForElementVisible(draftMessageLocator);

        Actions action = new Actions(getDriver())
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER);
        action.build().perform();

        MyLogger.info("Opening draft message by pressing keyboard buttons");

        return new DraftPage(driver);
    }

    public DraftsPage dragAndDropDraftToInbox(){
        waitForElementVisible(draftMessageLocator);
        waitForElementVisible(inboxLinkLocator);

        WebElement draft = driver.findElement(draftMessageLocator);
        WebElement inbox = driver.findElement(inboxLinkLocator);
        Actions dragAndDrop = new Actions(driver).dragAndDrop(draft, inbox);
        dragAndDrop.build().perform();
        MyLogger.info("Draft message was successfully drag and dropped to Inbox folder");

        return this;
    }

    public boolean isAlertAppeared(){
        MyLogger.info("Checking alert appearance");
        return isElementExists(alertLocator);
    }

}

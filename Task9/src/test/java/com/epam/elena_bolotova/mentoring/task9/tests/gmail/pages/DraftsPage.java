package com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages;

import com.epam.elena_bolotova.mentoring.task9.framework.core.ui.driver.Driver;
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

    public boolean isDraftMessageExists(){
        return isElementExists(draftMessageLocator);
    }

    public boolean isDraftsFolderEmpty(){
        waitForElementPresent(noDraftMessagesLocator);
        return Driver.getDriverInstance().findElement(noDraftMessagesLocator) != null;
    }

    public DraftPage openDraftMessage(){
        waitForElementVisible(draftMessageLocator);
        Driver.getDriverInstance().findElement(draftMessageLocator).click();
        return new DraftPage();
    }

    public DraftPage openDraftMessageByKeys(){
        waitForElementVisible(draftMessageLocator);

        Actions action = new Actions(Driver.getDriverInstance())
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER);
        action.build().perform();

        return new DraftPage();
    }

    public DraftsPage dragAndDropDraftToInbox(){
        waitForElementVisible(draftMessageLocator);
        waitForElementVisible(inboxLinkLocator);

        WebElement draft = Driver.getDriverInstance().findElement(draftMessageLocator);
        WebElement inbox = Driver.getDriverInstance().findElement(inboxLinkLocator);
        Actions dragAndDrop = new Actions(Driver.getDriverInstance()).dragAndDrop(draft, inbox);
        dragAndDrop.build().perform();

        return this;
    }

    public boolean isAlertAppeared(){
        return isElementExists(alertLocator);
    }

}

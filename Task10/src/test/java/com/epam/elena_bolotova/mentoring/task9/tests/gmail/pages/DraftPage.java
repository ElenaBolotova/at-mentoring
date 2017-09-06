package com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages;

import com.epam.elena_bolotova.mentoring.task9.framework.core.ui.driver.Driver;
import com.epam.elena_bolotova.mentoring.task9.tests.business_objects.Email;
import org.openqa.selenium.By;

public class DraftPage extends BasePage {
    private final By toFieldLocator = By.name("to");
    private final By subjectFieldLocator = By.name("subjectbox");
    private final By bodyFieldLocator = By.cssSelector("div[aria-label='Message Body']");
    private final By saveButtonLocator = By.xpath("//img[@aria-label='Save & Close']");
    private final By sendButtonLocator = By.cssSelector("div[aria-label^='Send']");
    private final By deleteButtonLocator = By.cssSelector("div[aria-label^='Discard draft']");

    public void saveDraft() {
        pressSaveButton();
    }

    public DraftPage fillDraft(Email email){
        fillTo(toFieldLocator, email.getAddressee());
        fillSubject(subjectFieldLocator, email.getSubject());
        fillBody(bodyFieldLocator, email.getBody());
        return this;
    }

    public void sendDraft() {
        pressSendButton();
    }

    public void deleteDraft(){
        waitForElementVisible(deleteButtonLocator);
        Driver.getDriverInstance().findElement(deleteButtonLocator).click();
    }

    private void fillTo(By locator, String addressee){
        waitForElementVisible(locator);
        Driver.getDriverInstance().findElement(locator).sendKeys(addressee);
    }

    private void fillSubject(By locator, String subject){
        waitForElementVisible(locator);
        Driver.getDriverInstance().findElement(locator).sendKeys(subject);
    }

    private void fillBody(By locator, String body){
        waitForElementVisible(locator);
        Driver.getDriverInstance().findElement(locator).sendKeys(body);
    }

    public String readTo(){
        waitForElementPresent(toFieldLocator);
        return Driver.getDriverInstance().findElement(toFieldLocator).getAttribute("value");
    }

    public String readSubject(){
        waitForElementPresent(subjectFieldLocator);
        return Driver.getDriverInstance().findElement(subjectFieldLocator).getAttribute("value");
    }

    public String readBody(){
        waitForElementPresent(bodyFieldLocator);
        return Driver.getDriverInstance().findElement(bodyFieldLocator).getText();
    }

    private void pressSendButton(){
        waitForElementPresent(sendButtonLocator);
        Driver.getDriverInstance().findElement(sendButtonLocator).click();
    }

    private void pressSaveButton(){
        waitForElementVisible(saveButtonLocator);
        Driver.getDriverInstance().findElement(saveButtonLocator).click();
    }
}

package com.epam.elena_bolotova.mentoring.task6.pageobject.pages;

import com.epam.elena_bolotova.mentoring.task6.pageobject.reporting.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DraftPage extends BasePage {
    private final By toFieldLocator = By.name("to");
    private final By subjectFieldLocator = By.name("subjectbox");
    private final By bodyFieldLocator = By.cssSelector("div[aria-label='Message Body']");
    private final By saveButtonLocator = By.xpath("//img[@aria-label='Save & Close']");
    private final By sendButtonLocator = By.cssSelector("div[aria-label^='Send']");
    private final By deleteButtonLocator = By.cssSelector("div[aria-label^='Discard draft']");

    public DraftPage(WebDriver driver) {
        super(driver);
    }

    public void saveDraft(String addressee, String subject, String body) {
        fillDraft(addressee, subject, body);
        pressSaveButton();
        MyLogger.info("Draft saved");
    }

    public DraftPage fillDraft(String addressee, String subject, String body){
        fillTo(toFieldLocator, addressee);
        fillSubject(subjectFieldLocator, subject);
        fillBody(bodyFieldLocator, body);
        MyLogger.info("Draft successfully filled");
        return this;
    }

    public void sendDraft() {
        pressSendButton();
        MyLogger.info("Draft was sent");
    }

    public void deleteDraft(){
        waitForElementVisible(deleteButtonLocator);
        driver.findElement(deleteButtonLocator).click();
        MyLogger.info("Draft was deleted");
    }

    private void fillTo(By locator, String addressee){
        waitForElementVisible(locator);
        driver.findElement(locator).sendKeys(addressee);
        MyLogger.info("To field filled with data");
    }

    private void fillSubject(By locator, String subject){
        waitForElementVisible(locator);
        driver.findElement(locator).sendKeys(subject);
        MyLogger.info("Subject field filled with data");
    }

    private void fillBody(By locator, String body){
        waitForElementVisible(locator);
        MyLogger.info("Body field filled with data");
        driver.findElement(locator).sendKeys(body);
    }

    public String readTo(){
        waitForElementPresent(toFieldLocator);
        MyLogger.info("Reading To field value");
        return driver.findElement(toFieldLocator).getAttribute("value");
    }

    public String readSubject(){
        waitForElementPresent(subjectFieldLocator);
        MyLogger.info("Reading Subject field value");
        return driver.findElement(subjectFieldLocator).getAttribute("value");
    }

    public String readBody(){
        waitForElementPresent(bodyFieldLocator);
        MyLogger.info("Reading Body field value");
        return driver.findElement(bodyFieldLocator).getText();
    }

    private void pressSendButton(){
        waitForElementPresent(sendButtonLocator);
        driver.findElement(sendButtonLocator).click();
        MyLogger.info("Send button is found");
    }

    private void pressSaveButton(){
        waitForElementVisible(saveButtonLocator);
        driver.findElement(saveButtonLocator).click();
        MyLogger.info("Save button is found");
    }
}

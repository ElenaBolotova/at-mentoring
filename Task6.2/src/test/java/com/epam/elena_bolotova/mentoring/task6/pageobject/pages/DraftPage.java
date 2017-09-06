package com.epam.elena_bolotova.mentoring.task6.pageobject.pages;

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
    }

    public DraftPage fillDraft(String addressee, String subject, String body){
        fillTo(toFieldLocator, addressee);
        fillSubject(subjectFieldLocator, subject);
        fillBody(bodyFieldLocator, body);
        return this;
    }

    public void sendDraft() {
        pressSendButton();
    }

    public void deleteDraft(){
        waitForElementVisible(deleteButtonLocator);
        driver.findElement(deleteButtonLocator).click();
    }

    private void fillTo(By locator, String addressee){
        waitForElementVisible(locator);
        driver.findElement(locator).sendKeys(addressee);
    }

    private void fillSubject(By locator, String subject){
        waitForElementVisible(locator);
        driver.findElement(locator).sendKeys(subject);
    }

    private void fillBody(By locator, String body){
        waitForElementVisible(locator);
        driver.findElement(locator).sendKeys(body);
    }

    public String readTo(){
        waitForElementPresent(toFieldLocator);
        return driver.findElement(toFieldLocator).getAttribute("value");
    }

    public String readSubject(){
        waitForElementPresent(subjectFieldLocator);
        return driver.findElement(subjectFieldLocator).getAttribute("value");
    }

    public String readBody(){
        waitForElementPresent(bodyFieldLocator);
        return driver.findElement(bodyFieldLocator).getText();
    }

    private void pressSendButton(){
        waitForElementPresent(sendButtonLocator);
        driver.findElement(sendButtonLocator).click();
    }

    private void pressSaveButton(){
        waitForElementVisible(saveButtonLocator);
        driver.findElement(saveButtonLocator).click();
    }
}

package com.epam.elena_bolotova.mentoring.task6.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftPage extends BasePage {

    @FindBy (name = "to")
    private WebElement toFieldLocator;

    @FindBy (name = "subjectbox")
    private WebElement subjectFieldLocator;

    @FindBy (css = "div[aria-label='Message Body']")
    private WebElement bodyFieldLocator;

    @FindBy (xpath = "//img[@aria-label='Save & Close']")
    private WebElement saveButtonLocator;

    @FindBy (css = "div[aria-label^='Send']")
    private WebElement sendButtonLocator;

    @FindBy (css = "div[aria-label^='Discard draft']")
    private WebElement deleteButtonLocator;

    public DraftPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
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
        deleteButtonLocator.click();
    }

    private void fillTo(WebElement webElement, String addressee){
        waitForElementVisible(webElement);
        webElement.sendKeys(addressee);
    }

    private void fillSubject(WebElement webElement, String subject){
        waitForElementVisible(webElement);
        webElement.sendKeys(subject);
    }

    private void fillBody(WebElement webElement, String body){
        waitForElementVisible(webElement);
        webElement.sendKeys(body);
    }

    public String readTo(){
        waitForElementVisible(toFieldLocator);
        return toFieldLocator.getAttribute("value");
    }

    public String readSubject(){
        waitForElementVisible(subjectFieldLocator);
        return subjectFieldLocator.getAttribute("value");
    }

    public String readBody(){
        waitForElementVisible(bodyFieldLocator);
        return bodyFieldLocator.getText();
    }

    private void pressSendButton(){
        waitForElementVisible(sendButtonLocator);
        sendButtonLocator.click();
    }

    private void pressSaveButton(){
        waitForElementVisible(saveButtonLocator);
        saveButtonLocator.click();
    }
}

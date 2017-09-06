package com.epam.elena_bolotova.mentoring.task6.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "identifierId")
    private WebElement usernameFieldLocator;

    @FindBy(id = "identifierNext")
    private WebElement usernameNextButtonLocator;

    @FindBy (name = "password")
    private WebElement passwordFieldLocator;

    @FindBy (id = "passwordNext")
    private WebElement passwordNextButtonLocator;


    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void open(){
        getDriver().get(getURL());
    }

    public MainPage login(String username, String password){
        loginAs(username, password);
        return new MainPage(getDriver());
    }

    public ErrorLoginPage incorrectLogin(String username, String password){
        loginAs(username, password);
        return new ErrorLoginPage(driver);
    }

    private void loginAs(String username, String password) {
        fillUsername(username);
        pressUsernameNextButton();
        fillPassword(password);
        pressPasswordNextButton();
    }

    private void pressPasswordNextButton() {
        waitForElementVisible(passwordNextButtonLocator);
        passwordNextButtonLocator.click();
    }

    private void fillPassword(String password) {
        waitForElementVisible(passwordFieldLocator);
        passwordFieldLocator.sendKeys(password);
    }

    private void pressUsernameNextButton() {
        waitForElementVisible(usernameNextButtonLocator);
        usernameNextButtonLocator.click();
    }

    private void fillUsername(String username) {
        waitForElementVisible(usernameFieldLocator);
        usernameFieldLocator.sendKeys(username);
    }

}

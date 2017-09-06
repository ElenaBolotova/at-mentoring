package com.epam.elena_bolotova.mentoring.task6.pageobject.pages;
import com.epam.elena_bolotova.mentoring.task6.pageobject.reporting.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By usernameFieldLocator = By.id("identifierId");
    private final By usernameNextButtonLocator = By.id("identifierNext");
    private final By passwordFieldLocator = By.name("password");
    private final By passwordNextButtonLocator = By.id("passwordNext");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        MyLogger.info("Opening " + getURL());
        getDriver().get(getURL());
    }

    public MainPage login(String username, String password){
        loginAs(username, password);
        MyLogger.info("Successfully logged in as " + username + "/" + password);
        return new MainPage(getDriver());
    }

    public ErrorLoginPage incorrectLogin(String username, String password){
        loginAs(username, password);
        MyLogger.error("User has incorrect login");
        return new ErrorLoginPage(driver);
    }

    private void loginAs(String username, String password) {
        MyLogger.info("Trying to log in as " + username + "/" + password);
        fillUsername(username);
        pressUsernameNextButton();
        fillPassword(password);
        pressPasswordNextButton();
        MyLogger.info("Username and password fields are filled");
    }

    private void pressPasswordNextButton() {
        driver.findElement(passwordNextButtonLocator).click();
        MyLogger.info("Pressing Next button");
    }

    private void fillPassword(String password) {
        waitForElementVisible(passwordFieldLocator);
        MyLogger.info("Filling password field");
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }

    private void pressUsernameNextButton() {
        driver.findElement(usernameNextButtonLocator).click();
        MyLogger.info("Pressing Next button");
    }

    private void fillUsername(String username) {
        waitForElementVisible(usernameFieldLocator);
        MyLogger.info("Filling username field");
        driver.findElement(usernameFieldLocator).sendKeys(username);
    }

}

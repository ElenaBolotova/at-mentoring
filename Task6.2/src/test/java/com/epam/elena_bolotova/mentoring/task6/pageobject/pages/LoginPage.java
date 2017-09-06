package com.epam.elena_bolotova.mentoring.task6.pageobject.pages;
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
        driver.findElement(passwordNextButtonLocator).click();
    }

    private void fillPassword(String password) {
        waitForElementVisible(passwordFieldLocator);
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }

    private void pressUsernameNextButton() {
        driver.findElement(usernameNextButtonLocator).click();
    }

    private void fillUsername(String username) {
        waitForElementVisible(usernameFieldLocator);
        driver.findElement(usernameFieldLocator).sendKeys(username);
    }

}

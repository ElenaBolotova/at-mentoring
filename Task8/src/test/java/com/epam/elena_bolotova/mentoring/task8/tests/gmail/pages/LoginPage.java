package com.epam.elena_bolotova.mentoring.task8.tests.gmail.pages;
import com.epam.elena_bolotova.mentoring.task8.tests.gmail.bo.User;
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

    public MainPage logIn(User user){
        loginAs(user);
        return new MainPage(getDriver());
    }

    public ErrorLoginPage incorrectLogIn(User user){
        loginAs(user);
        return new ErrorLoginPage(driver);
    }

    private void loginAs(User user) {
        fillUsername(user.getUsername());
        pressUsernameNextButton();
        fillPassword(user.getPassword());
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

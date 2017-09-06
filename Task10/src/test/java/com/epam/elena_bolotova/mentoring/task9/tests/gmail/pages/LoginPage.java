package com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages;
import com.epam.elena_bolotova.mentoring.task9.framework.core.ui.driver.Driver;
import com.epam.elena_bolotova.mentoring.task9.tests.business_objects.User;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By usernameFieldLocator = By.id("identifierId");
    private final By usernameNextButtonLocator = By.id("identifierNext");
    private final By passwordFieldLocator = By.name("password");
    private final By passwordNextButtonLocator = By.id("passwordNext");

    public void open(){
        Driver.getDriverInstance().get(getURL());
    }

    public MainPage logIn(User user){
        logInAs(user);
        return new MainPage();
    }

    public ErrorLoginPage incorrectLogIn(User user){
        logInAs(user);
        return new ErrorLoginPage();
    }

    private void logInAs(User user) {
        fillUsername(user.getUsername());
        pressUsernameNextButton();
        fillPassword(user.getPassword());
        pressPasswordNextButton();
    }

    private void pressPasswordNextButton() {
        Driver.getDriverInstance().findElement(passwordNextButtonLocator).click();
    }

    private void fillPassword(String password) {
        waitForElementVisible(passwordFieldLocator);
        Driver.getDriverInstance().findElement(passwordFieldLocator).sendKeys(password);
    }

    private void pressUsernameNextButton() {
        Driver.getDriverInstance().findElement(usernameNextButtonLocator).click();
    }

    private void fillUsername(String username) {
        waitForElementVisible(usernameFieldLocator);
        Driver.getDriverInstance().findElement(usernameFieldLocator).sendKeys(username);
    }

}

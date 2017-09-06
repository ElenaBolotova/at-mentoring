package com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages;

import com.epam.elena_bolotova.mentoring.task9.framework.core.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ErrorLoginPage extends BasePage {
    private final By incorrectLoginTextLocator = By.xpath("//div[contains(text(),'Wrong password.')]");

    public String getErrorMessage(){
        return Driver.getDriverInstance().findElement(incorrectLoginTextLocator).getText();
    }
}

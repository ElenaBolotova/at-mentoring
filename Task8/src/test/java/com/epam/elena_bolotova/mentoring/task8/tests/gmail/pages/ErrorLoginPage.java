package com.epam.elena_bolotova.mentoring.task8.tests.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ErrorLoginPage extends BasePage {
    private final By incorrectLoginTextLocator = By.xpath("//div[contains(text(),'Wrong password.')]");

    public ErrorLoginPage(WebDriver driver) {
        super(driver);
    }

    public String getErrorMessage(){
        return driver.findElement(incorrectLoginTextLocator).getText();
    }
}

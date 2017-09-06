package com.epam.elena_bolotova.mentoring.task6.pageobject.pages;

import com.epam.elena_bolotova.mentoring.task6.pageobject.reporting.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ErrorLoginPage extends BasePage {
    private final By incorrectLoginTextLocator = By.xpath("//div[contains(text(),'Wrong password.')]");

    public ErrorLoginPage(WebDriver driver) {
        super(driver);
    }

    public String getErrorMessage(){
        MyLogger.info("Checking error message");
        return driver.findElement(incorrectLoginTextLocator).getText();
    }
}

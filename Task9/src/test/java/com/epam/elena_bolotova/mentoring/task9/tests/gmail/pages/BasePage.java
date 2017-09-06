package com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages;

import com.epam.elena_bolotova.mentoring.task9.framework.core.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected final String URL = "http://gmail.com";
    private static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 20;

    protected String getURL() {return URL;}

    protected boolean isElementExists(By locator){
        waitForElementVisible(locator);
        return Driver.getDriverInstance().findElement(locator) != null;
    }

    protected void waitForElementPresent(By locator) {
        new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected void waitForElementVisible(By locator) {
        new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}

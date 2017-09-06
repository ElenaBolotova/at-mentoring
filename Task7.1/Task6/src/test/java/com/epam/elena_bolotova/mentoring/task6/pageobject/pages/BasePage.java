package com.epam.elena_bolotova.mentoring.task6.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected final String URL = "http://gmail.com";
    private static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 20;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getURL() {return URL;}

    public boolean isElementExists(By locator){
        waitForElementVisible(locator);
        return driver.findElement(locator) != null;
    }

    protected void waitForElementPresent(By locator) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected void waitForElementVisible(By locator) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}

package com.epam.elena_bolotova.mentoring.task6.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected final String URL = "http://gmail.com";
    private static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 15;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getURL() {return URL;}

    public boolean isElementExists(WebElement webElement){
        waitForElementVisible(webElement);
        return webElement != null;
    }

    protected void waitForElementVisible(WebElement webElement) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(webElement));
    }
}

package com.epam.elena_bolotova.mentoring.task6.pageobject.driver;

import com.epam.elena_bolotova.mentoring.task6.pageobject.reporting.MyLogger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class DriverDecorator implements WebDriver {
    protected WebDriver driver;
    private static final String SCREENSHOTS_NAME_TPL = "./target/screenshots/scr";

    public DriverDecorator(WebDriver driver) {
        this.driver = driver;
    }

    public void get(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {
        highlightElement(by);
        return driver.findElement(by);
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    public Navigation navigate() {
        return driver.navigate();
    }

    public Options manage() {
        return driver.manage();
    }

    public void highlightElement(By by) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", driver.findElement(by));
    }

    public void takeScreenshot() {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = SCREENSHOTS_NAME_TPL + System.nanoTime();
            File copy = new File(screenshotName + ".png");
            FileUtils.copyFile(screenshot, copy);
            MyLogger.info("Saved screenshot: " + screenshotName);
        } catch (IOException e) {
            MyLogger.error("Failed to make screenshot");
        }
    }
}

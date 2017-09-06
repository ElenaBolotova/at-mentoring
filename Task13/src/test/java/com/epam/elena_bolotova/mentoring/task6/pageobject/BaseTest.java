package com.epam.elena_bolotova.mentoring.task6.pageobject;

import com.epam.elena_bolotova.mentoring.task6.pageobject.driver.DriverDecorator;
import com.epam.elena_bolotova.mentoring.task6.pageobject.pages.LoginPage;
import com.epam.elena_bolotova.mentoring.task6.pageobject.pages.MainPage;
import com.epam.elena_bolotova.mentoring.task6.pageobject.reporting.MyLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

public abstract class BaseTest {
    private WebDriver driver;

    @BeforeClass(description = "Start browser", alwaysRun = true)
    protected void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\exe\\GeckoDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver = new DriverDecorator(driver);
        MyLogger.info("creating driver");
        WebDriverWait wait = new WebDriverWait(driver, 15);
    }

    @AfterClass(description = "Close browser", alwaysRun = true)
    protected void tearDown(){
        if (driver != null) {
            driver.close();
            MyLogger.info("closing driver");
        }
    }

    @AfterMethod(description = "Check test result", alwaysRun = true)
    protected void checkSuccess(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            ((DriverDecorator)driver).takeScreenshot();
        }
    }

    public LoginPage openLoginPage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        return loginPage;
    }

    @BeforeGroups("needLogin")
    @Parameters({"username", "password"})
    public MainPage login(@Optional ("tuser5500@gmail.com") String username, @Optional ("Mentoring") String password){
        return openLoginPage().login(username, password);
    }


    protected WebDriver getDriver() {
        return driver;
    }
}

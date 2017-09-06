package com.epam.elena_bolotova.mentoring.task6.pageobject;

import com.epam.elena_bolotova.mentoring.task6.pageobject.pages.LoginPage;
import com.epam.elena_bolotova.mentoring.task6.pageobject.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public abstract class BaseTest {
    private WebDriver driver;

    @BeforeClass(description = "Start browser", alwaysRun = true)
    protected void setUp() {
        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 15);
    }

    @AfterClass(description = "Close browser", alwaysRun = true)
    protected void tearDown(){
        if (driver != null) {
            driver.close();
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

package com.epam.elena_bolotova.mentoring.task8.tests;

import com.epam.elena_bolotova.mentoring.task8.framework.util.UserUtils;
import com.epam.elena_bolotova.mentoring.task8.tests.gmail.bo.User;
import com.epam.elena_bolotova.mentoring.task8.tests.gmail.pages.LoginPage;
import com.epam.elena_bolotova.mentoring.task8.tests.gmail.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public abstract class BaseTest {
    private WebDriver driver;
    protected User user;

    @BeforeClass(description = "Start browser", alwaysRun = true)
    protected void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/driverbinaries/geckodriver.exe");
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
    public MainPage logIn(@Optional ("tuser5500@gmail.com") String username, @Optional ("Mentoring") String password){
        return openLoginPage().logIn(UserUtils.createUser(username, password));
    }


    protected WebDriver getDriver() {
        return driver;
    }
}

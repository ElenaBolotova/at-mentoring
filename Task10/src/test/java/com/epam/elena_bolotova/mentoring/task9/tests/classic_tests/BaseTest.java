package com.epam.elena_bolotova.mentoring.task9.tests.classic_tests;

import com.epam.elena_bolotova.mentoring.task9.framework.core.ui.driver.Driver;
import com.epam.elena_bolotova.mentoring.task9.framework.util.UserUtils;
import com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages.LoginPage;
import com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages.MainPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public abstract class BaseTest {

    @BeforeClass(description = "Start browser", alwaysRun = true)
    protected void setUp() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriverInstance(), 15);
    }

    @AfterSuite(description = "Close browser", alwaysRun = true)
    protected void tearDown(){
        Driver.getDriverInstance().quit();
    }

    protected LoginPage openLoginPage(){
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        return loginPage;
    }

    @BeforeGroups("needLogin")
    @Parameters({"username", "password"})
    protected MainPage logIn(@Optional ("tuser5500@gmail.com") String username, @Optional ("Mentoring") String password){
        return openLoginPage().logIn(UserUtils.createUser(username, password));
    }
}

package com.epam.elena_bolotova.mentoring.task6.pageobject;

import com.epam.elena_bolotova.mentoring.task6.pageobject.reporting.MyLogger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.elena_bolotova.mentoring.task6.pageobject.dataproviders.LoginDataProvider;
import com.epam.elena_bolotova.mentoring.task6.pageobject.pages.LoginPage;

public class IncorrectLoginTest extends BaseTest{

    @Test(description = "Login with incorrect password",
            dataProviderClass = LoginDataProvider.class, dataProvider = "incorrectLoginDataProvider")
    public void incorrectLoginGmailTest(String username, String password, String expectedErrorMessage){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        String actualErrorMessage = loginPage.incorrectLogin(username, password).getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Incorrect error message");
        MyLogger.info("User was not logged in with incorrect login");
    }
}

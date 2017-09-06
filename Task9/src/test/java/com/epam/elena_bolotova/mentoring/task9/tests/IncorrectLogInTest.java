package com.epam.elena_bolotova.mentoring.task9.tests;

import com.epam.elena_bolotova.mentoring.task9.framework.core.ui.driver.Driver;
import com.epam.elena_bolotova.mentoring.task9.framework.util.UserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.elena_bolotova.mentoring.task9.tests.gmail.dataproviders.LoginDataProvider;
import com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages.LoginPage;

public class IncorrectLogInTest extends BaseTest{

    @Test(description = "Log in with incorrect password",
            dataProviderClass = LoginDataProvider.class, dataProvider = "incorrectLoginDataProvider")
    public void incorrectLogInGmailTest(String username, String password, String expectedErrorMessage){
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        String actualErrorMessage = loginPage.incorrectLogIn(UserUtils.createUser(username, password)).getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Incorrect error message");
    }
}

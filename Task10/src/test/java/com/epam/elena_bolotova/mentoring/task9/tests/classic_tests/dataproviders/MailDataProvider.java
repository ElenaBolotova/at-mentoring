package com.epam.elena_bolotova.mentoring.task9.tests.classic_tests.dataproviders;

import org.testng.annotations.DataProvider;

public class MailDataProvider {

    @DataProvider(name = "mailDataProvider")
    public static Object[][] mailDataProvider() {
        return new Object[][]{
                {"elena_bolotova@epam.com", "Test email", "This is my test email for hometask #5."}
        };
    }
}

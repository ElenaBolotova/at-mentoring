package com.epam.elena_bolotova.mentoring.task9.tests.gmail.dataproviders;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    private static final String USER_NAME = "tuser5500@gmail.com";

    @DataProvider(name = "incorrectLoginDataProvider")
    public static Object[][] incorrectLoginDataProvider() {
        return new Object[][]{
                {USER_NAME, "111", "Wrong password. Try again."}
        };
    }
}
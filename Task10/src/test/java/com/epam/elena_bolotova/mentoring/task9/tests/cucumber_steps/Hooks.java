package com.epam.elena_bolotova.mentoring.task9.tests.cucumber_steps;

import com.epam.elena_bolotova.mentoring.task9.framework.core.ui.driver.Driver;
import cucumber.api.java.After;

public class Hooks {

    @After
    public void clearData() {
        Driver.quit();
    }
}

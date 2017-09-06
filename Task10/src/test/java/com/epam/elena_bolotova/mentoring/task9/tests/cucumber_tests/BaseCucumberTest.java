package com.epam.elena_bolotova.mentoring.task9.tests.cucumber_tests;

import com.epam.elena_bolotova.mentoring.task9.framework.core.ui.driver.Driver;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class BaseCucumberTest extends AbstractTestNGCucumberTests {
    @BeforeClass(description = "Start browser, add implicit wait and maximize window")
    public void startBrowser() {
        Driver.getDriverInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriverInstance().manage().window().maximize();
    }

    @AfterClass
    public void closeBrowser(){
        Driver.quit();
    }
}

package com.epam.elena_bolotova.mentoring.task9.framework.core.ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FFDriverCreator extends DriverCreator{
    @Override
    public WebDriver FactoryMethod() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/driverbinaries/geckodriver.exe");
        return new FirefoxDriver();
    }
}

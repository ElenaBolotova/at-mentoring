package com.epam.elena_bolotova.mentoring.task9.framework.core.ui.driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverCreator {
    protected WebDriver driver;

    public abstract WebDriver FactoryMethod();
}

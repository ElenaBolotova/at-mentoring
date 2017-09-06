package com.epam.elena_bolotova.mentoring.task9.framework.core.ui.driver;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static final Browsers DEFAULT_BROWSER = Browsers.Chrome;

    public enum Browsers{
        Chrome,
        FF,
    }

    private static HashMap<Browsers, WebDriver> drivers;

    static {
        drivers = new HashMap<Browsers, WebDriver>();
    }

    private Driver(){}

    public static WebDriver getDriverInstance(Browsers browser) {
        WebDriver driver;
        if (!drivers.containsKey(browser)) {
            DriverCreator creator;
            switch (browser) {
                case Chrome: {
                    creator = new ChromeDriverCreator();
                    break;
                }
                case FF: {
                    creator = new FFDriverCreator();
                    break;
                }
                default:
                    throw new IndexOutOfBoundsException("Unknown web driver specified: " + browser);
            }
            driver = creator.FactoryMethod();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            driver = new DriverDecorator(driver);
            drivers.put(browser, driver);
        } else{
            driver = drivers.get(browser);
        }
        return driver;
    }

    public static WebDriver getDriverInstance() {
        return getDriverInstance(DEFAULT_BROWSER);
    }
}

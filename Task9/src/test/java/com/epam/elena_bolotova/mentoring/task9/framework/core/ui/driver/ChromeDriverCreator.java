package com.epam.elena_bolotova.mentoring.task9.framework.core.ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeDriverCreator extends DriverCreator {
    @Override
    public WebDriver FactoryMethod() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driverbinaries/chromedriver.exe");
        return new ChromeDriver();
    }
}

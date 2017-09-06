package com.epam.elena_bolotova.mentoring.task6.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SentMailPage extends BasePage {

    private final By mailSubjectLocator = By.xpath("//table//span[.='Test email']");

    public SentMailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDraftMessageExists(){
        return isElementExists(mailSubjectLocator);
    }
}

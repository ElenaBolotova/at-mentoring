package com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SentMailPage extends BasePage {

    private final By mailSubjectLocator = By.xpath("//table//span[.='Test email']");

    public boolean isDraftMessageExists(){
        return isElementExists(mailSubjectLocator);
    }
}

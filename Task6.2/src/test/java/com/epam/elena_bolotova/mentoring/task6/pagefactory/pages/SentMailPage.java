package com.epam.elena_bolotova.mentoring.task6.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SentMailPage extends BasePage {

    @FindBy (xpath = "//table//span[.='Test email']")
    private WebElement mailSubjectLocator;

    public SentMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean isDraftMessageExists(){
        return isElementExists(mailSubjectLocator);
    }
}

package com.epam.elena_bolotova.mentoring.task6.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ErrorLoginPage extends BasePage {
    @FindBy (xpath = "//div[contains(text(),'Wrong password.')]")
    private WebElement incorrectLoginTextLocator;

    public ErrorLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getErrorMessage(){
        return incorrectLoginTextLocator.getText();
    }
}

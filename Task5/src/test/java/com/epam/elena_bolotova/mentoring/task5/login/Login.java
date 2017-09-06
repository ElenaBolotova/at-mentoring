package com.epam.elena_bolotova.mentoring.task5.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class Login {
    private final static String USERNAME = "tuser5500@gmail.com";
    private final static String PASSWORD = "Mentoring";


     public void loginGmail(WebDriver driver, Wait wait){
         WebElement userName = driver.findElement(By.id("identifierId"));
         Assert.assertNotNull(userName, "Username field not found");
         userName.sendKeys(USERNAME);

         WebElement userNameNext = driver.findElement(By.id("identifierNext"));
         Assert.assertNotNull(userNameNext, "Next button not found");
         userNameNext.click();

         By passwordBy = By.name("password");
         wait.until(ExpectedConditions.elementToBeClickable(passwordBy));
         WebElement password = driver.findElement(passwordBy);
         Assert.assertNotNull(password, "Password field not found");
         password.sendKeys(PASSWORD);

         WebElement passwordNext = driver.findElement(By.id("passwordNext"));
         Assert.assertNotNull(passwordNext, "Next button not found");
         passwordNext.click();
     }

    public void logoutGmail(WebDriver driver, Wait wait){
        WebElement signOut = driver.findElement(By.xpath("//a[contains(@href, 'SignOut')]"));
        Assert.assertNotNull(signOut, "Signout options menu not found");
        signOut.click();

        By logOutBy = By.xpath("//a[contains(@href, 'Logout')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(logOutBy));
        WebElement logOut = driver.findElement(logOutBy);
        Assert.assertNotNull(logOut, "Logout link not found");
        logOut.click();
    }
}

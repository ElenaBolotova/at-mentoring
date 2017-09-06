package com.epam.elena_bolotova.mentoring.task5;

import com.epam.elena_bolotova.mentoring.task5.login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class GmailTest {
    private WebDriver driver;
    private final static String BASEURL = "http://gmail.com";
    private WebDriverWait wait;

    @BeforeClass (alwaysRun = true)
    public void setUp() throws Exception{
        System.setProperty("webdriver.gecko.driver", "/bin/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(BASEURL);
        wait = new WebDriverWait(driver, 15);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
       if (driver != null) {
            driver.close();
       }
    }

    @Test
    public void sendDraft() throws InterruptedException {
        //Login to the mail box.
        Login login = new Login();
        login.loginGmail(driver, wait);

        By composeBy = By.xpath("//div[contains(@role, 'button') and contains(text(),'COMPOSE')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(composeBy));

        WebElement compose = driver.findElement(composeBy);
        //Assert, that the login is successful.
        Assert.assertNotNull(compose, "Compose button not found");
        //Create a new mail (fill addressee, subject and body fields).
        compose.click();

        String addressee = "elena_bolotova@epam.com";
        String subject = "Test email";
        String body = "This is my test email for hometask #5.";

        By toBy = By.name("to");
        wait.until(ExpectedConditions.elementToBeClickable(toBy));
        WebElement to = driver.findElement(toBy);
        Assert.assertNotNull(to, "To field not found");
        to.sendKeys(addressee);

        WebElement subjectBox = driver.findElement(By.name("subjectbox"));
        Assert.assertNotNull(subjectBox, "Subject field not found");
        driver.findElement(By.name("subjectbox")).sendKeys(subject);

        By messageBoxBy = By.cssSelector("div[aria-label=\"Message Body\"]");
        WebElement messageBox = driver.findElement(messageBoxBy);
        Assert.assertNotNull(messageBox, "Body field not found");
        driver.findElement(messageBoxBy).sendKeys(body);

        WebElement saveAndClose = driver.findElement(By.xpath("//img[@aria-label='Save & Close']"));
        Assert.assertNotNull(saveAndClose, "Save&Close button not found");
        //Save the mail as a draft.
        saveAndClose.click();

        By draftsBy = By.partialLinkText("Drafts");
        WebElement drafts = driver.findElement(draftsBy);
        Assert.assertNotNull(drafts, "Drafts link not found");
        driver.findElement(draftsBy).click();

        By draftBy = By.xpath("//table//span[.=\"Test email\"]");
        wait.until(ExpectedConditions.presenceOfElementLocated(draftBy));
        WebElement draft = driver.findElement(draftBy);
        //Verify, that the mail presents in ‘Drafts’ folder.
        Assert.assertNotNull(draft,"Saved draft not found");
        driver.findElement(draftBy).click();

        //Verify the draft content (addressee, subject and body – should be the same
        to = driver.findElement(toBy);
        Assert.assertNotNull(to, "To field not found");
        String tempTo = to.getAttribute("value");
        Assert.assertEquals(tempTo, addressee);

        By subjectBy = By.cssSelector("input[name=\"subject\"]");
        wait.until(ExpectedConditions.presenceOfElementLocated(subjectBy));

        WebElement subj = driver.findElement(subjectBy);
        Assert.assertNotNull(subj, "Subject field not found");
        String tempSubj = subj.getAttribute("value");
        Assert.assertEquals(tempSubj, subject);

        wait.until(ExpectedConditions.presenceOfElementLocated(messageBoxBy));
        messageBox = driver.findElement(messageBoxBy);
        Assert.assertNotNull(messageBox, "Body field not found");
        String tempBody = driver.findElement(messageBoxBy).getText();
        Assert.assertEquals(tempBody, body);

        By sendBy = By.cssSelector("div[aria-label^=\"Send\"]");
        WebElement send = driver.findElement(sendBy);
        Assert.assertNotNull(send, "Send button not found");
        //Send the mail.
        driver.findElement(sendBy).click();

        By noDraftBy = By.xpath("//td[contains(text(),\"You don't have any saved drafts.\")]");
        wait.until(ExpectedConditions.presenceOfElementLocated(noDraftBy));

        WebElement noDraft = driver.findElement(noDraftBy);
        //Verify, that the mail disappeared from ‘Drafts’ folder.
        Assert.assertNotNull(noDraft, "Drafts is not empty");

        WebElement sentMail = driver.findElement(By.partialLinkText("Sent Mail"));
        Assert.assertNotNull(sentMail, "Sent Mail link not found");
        sentMail.click();

        draft = driver.findElement(draftBy);
        //Verify, that the mail is in ‘Sent’ folder.
        Assert.assertNotNull(draft, "Sent draft not found");

        //Log off.
        login.logoutGmail(driver, wait);
    }
}

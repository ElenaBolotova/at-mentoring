package com.epam.elena_bolotova.mentoring.task6.pageobject;

import com.epam.elena_bolotova.mentoring.task6.pageobject.reporting.MyLogger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.elena_bolotova.mentoring.task6.pageobject.dataproviders.MailDataProvider;
import com.epam.elena_bolotova.mentoring.task6.pageobject.pages.DraftPage;
import com.epam.elena_bolotova.mentoring.task6.pageobject.pages.DraftsPage;
import com.epam.elena_bolotova.mentoring.task6.pageobject.pages.MainPage;

public class SaveAndSendDraftTest extends BaseTest{
    private MainPage mainPage;
    private DraftPage draftPage;
    private DraftsPage draftsPage;

    @Test(groups = {"needLogin"}, description = "Save draft message",
            dataProviderClass = MailDataProvider.class, dataProvider = "mailDataProvider")
    public void saveDraftTest(String addressee, String subject, String body){
        mainPage = new MainPage(getDriver());
        mainPage.composeDraft().saveDraft(addressee, subject, body);
        MyLogger.info("Draft was successfully created");
    }

    @Test(description = "Check draft message in Drafts",
            dependsOnMethods = {"saveDraftTest"})
    public void checkDraftInDraftsTest(){
        draftsPage = mainPage.openDraftsFolder();
        Assert.assertTrue(draftsPage.isDraftMessageExists(), "Draft doesn't exist");
        MyLogger.info("Draft is in Drafts folder");
    }

    @Test(description = "Check draft message content",
            dataProviderClass = MailDataProvider.class, dataProvider = "mailDataProvider",
            dependsOnMethods = {"checkDraftInDraftsTest"})
    public void checkDraftContentTest(String addressee, String subject, String body){
        draftPage = draftsPage.openDraftMessage();
        Assert.assertEquals(draftPage.readTo(), addressee, "Invalid addressee");
        Assert.assertEquals(draftPage.readSubject(), subject, "Invalid subject");
        Assert.assertEquals(draftPage.readBody(), body, "Invalid body");
        MyLogger.info("Draft content is correct");
    }

    @Test(description = "Send draft message", dependsOnMethods = {"checkDraftContentTest"})
    public void sendDraftTest(){
        draftPage.sendDraft();
        Assert.assertTrue(draftsPage.isDraftsFolderEmpty(), "Draft message hasn't been sent");
        MyLogger.info("Draft was sent successfully");
    }

    @Test(description = "Check draft message in Sent Mail",
            dependsOnMethods = {"sendDraftTest"})
    public void checkDraftInSentMailTest(){
        Assert.assertTrue(mainPage.openSentMailFolder().isDraftMessageExists(), "There is no draft message in Sent Mail");
        MyLogger.info("Message is in Sent Mail folder");
        mainPage.openAccountPage().signOut();
    }
}

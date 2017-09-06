package com.epam.elena_bolotova.mentoring.task8.tests;

import com.epam.elena_bolotova.mentoring.task8.framework.util.EmailUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.elena_bolotova.mentoring.task8.tests.gmail.dataproviders.MailDataProvider;
import com.epam.elena_bolotova.mentoring.task8.tests.gmail.pages.DraftPage;
import com.epam.elena_bolotova.mentoring.task8.tests.gmail.pages.DraftsPage;
import com.epam.elena_bolotova.mentoring.task8.tests.gmail.pages.MainPage;

public class SaveAndSendDraftTest extends BaseTest{
    private MainPage mainPage;
    private DraftPage draftPage;
    private DraftsPage draftsPage;

    @Test(groups = {"needLogin"}, description = "Save draft message",
            dataProviderClass = MailDataProvider.class, dataProvider = "mailDataProvider")
    public void saveDraftTest(String addressee, String subject, String body){
        mainPage = new MainPage(getDriver());
        mainPage.composeDraft().saveDraft(EmailUtils.createEmail(addressee, subject, body));
    }

    @Test(description = "Check draft message in Drafts",
            dependsOnMethods = {"saveDraftTest"})
    public void checkDraftInDraftsTest(){
        draftsPage = mainPage.openDraftsFolder();
        Assert.assertTrue(draftsPage.isDraftMessageExists(), "Draft doesn't exist");
    }

    @Test(description = "Check draft message content",
            dataProviderClass = MailDataProvider.class, dataProvider = "mailDataProvider",
            dependsOnMethods = {"checkDraftInDraftsTest"})
    public void checkDraftContentTest(String addressee, String subject, String body){
        draftPage = draftsPage.openDraftMessage();
        Assert.assertEquals(draftPage.readTo(), addressee, "Invalid addressee");
        Assert.assertEquals(draftPage.readSubject(), subject, "Invalid subject");
        Assert.assertEquals(draftPage.readBody(), body, "Invalid body");
    }

    @Test(description = "Send draft message", dependsOnMethods = {"checkDraftContentTest"})
    public void sendDraftTest(){
        draftPage.sendDraft();
        Assert.assertTrue(draftsPage.isDraftsFolderEmpty(), "Draft message hasn't been sent");
    }

    @Test(description = "Check draft message in Sent Mail",
            dependsOnMethods = {"sendDraftTest"})
    public void checkDraftInSentMailTest(){
        Assert.assertTrue(mainPage.openSentMailFolder().isDraftMessageExists(), "There is no draft message in Sent Mail");
        mainPage.openAccountPage().signOut();
    }
}

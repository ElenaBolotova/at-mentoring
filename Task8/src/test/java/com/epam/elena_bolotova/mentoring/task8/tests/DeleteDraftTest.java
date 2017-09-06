package com.epam.elena_bolotova.mentoring.task8.tests;

import com.epam.elena_bolotova.mentoring.task8.framework.util.EmailUtils;
import com.epam.elena_bolotova.mentoring.task8.tests.gmail.dataproviders.MailDataProvider;
import com.epam.elena_bolotova.mentoring.task8.tests.gmail.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteDraftTest extends BaseTest {

    @Test(groups = {"needLogin"},
            description = "Create and delete draft message",
            dataProviderClass = MailDataProvider.class,
            dataProvider = "mailDataProvider")
    public void deleteDraftTest(String addressee, String subject, String body){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.composeDraft().fillDraft(EmailUtils.createEmail(addressee, subject, body)).deleteDraft();

        String expectedMessage = "Your message has been discarded.";
        Assert.assertEquals(mainPage.getDraftDiscardMessage(), expectedMessage, "Draft hasn't been deleted");
    }
}
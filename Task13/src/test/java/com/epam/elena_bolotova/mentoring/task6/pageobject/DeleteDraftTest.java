package com.epam.elena_bolotova.mentoring.task6.pageobject;

import com.epam.elena_bolotova.mentoring.task6.pageobject.dataproviders.MailDataProvider;
import com.epam.elena_bolotova.mentoring.task6.pageobject.pages.MainPage;
import com.epam.elena_bolotova.mentoring.task6.pageobject.reporting.MyLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteDraftTest extends BaseTest {

    @Test(groups = {"needLogin"},
            description = "Create and delete draft message",
            dataProviderClass = MailDataProvider.class,
            dataProvider = "mailDataProvider")
    public void deleteDraftTest(String addressee, String subject, String body){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.composeDraft().fillDraft(addressee, subject, body).deleteDraft();

        String expectedMessage = "Your message has been discarded.";
        Assert.assertEquals(mainPage.getDraftDiscardMessage(), expectedMessage, "Draft hasn't been deleted");
        MyLogger.info("Draft was successfully created, checked and deleted");
    }
}

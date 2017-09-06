package com.epam.elena_bolotova.mentoring.task6.pageobject;

import com.epam.elena_bolotova.mentoring.task6.pageobject.reporting.MyLogger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.elena_bolotova.mentoring.task6.pageobject.dataproviders.MailDataProvider;
import com.epam.elena_bolotova.mentoring.task6.pageobject.pages.DraftPage;
import com.epam.elena_bolotova.mentoring.task6.pageobject.pages.MainPage;

public class SelectDraftTest extends BaseTest{

    @Test(groups = {"needLogin"}, description = "Select draft message",
            dataProviderClass = MailDataProvider.class, dataProvider = "mailDataProvider")
    public void selectDraftTest(String addressee, String subject, String body){
        new MainPage(getDriver()).composeDraft().saveDraft(addressee, subject, body);
        DraftPage draftPage = new MainPage(getDriver()).openDraftsFolder().openDraftMessageByKeys();
        Assert.assertEquals(draftPage.readBody(), body, "Invalid body");
        MyLogger.info("Draft was successfully created and opened by pressing keyboard buttons");
    }
}

package com.epam.elena_bolotova.mentoring.task8.tests;

import com.epam.elena_bolotova.mentoring.task8.framework.util.EmailUtils;
import com.epam.elena_bolotova.mentoring.task8.tests.gmail.bo.Email;
import com.epam.elena_bolotova.mentoring.task8.tests.gmail.dataproviders.MailDataProvider;
import com.epam.elena_bolotova.mentoring.task8.tests.gmail.pages.DraftPage;
import com.epam.elena_bolotova.mentoring.task8.tests.gmail.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectDraftTest extends BaseTest{

    @Test(groups = {"needLogin"}, description = "Select draft message",
            dataProviderClass = MailDataProvider.class, dataProvider = "mailDataProvider")
    public void selectDraftTest(String addressee, String subject, String body){
        new MainPage(getDriver()).composeDraft().saveDraft(EmailUtils.createEmail(addressee, subject, body));
        DraftPage draftPage = new MainPage(getDriver()).openDraftsFolder().openDraftMessageByKeys();
        Assert.assertEquals(draftPage.readBody(), body, "Invalid body");
    }
}

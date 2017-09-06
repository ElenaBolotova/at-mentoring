package com.epam.elena_bolotova.mentoring.task9.tests;

import com.epam.elena_bolotova.mentoring.task9.framework.core.ui.driver.Driver;
import com.epam.elena_bolotova.mentoring.task9.framework.util.EmailUtils;
import com.epam.elena_bolotova.mentoring.task9.tests.gmail.dataproviders.MailDataProvider;
import com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages.DraftPage;
import com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectDraftTest extends BaseTest{

    @Test(groups = {"needLogin"}, description = "Select draft message",
            dataProviderClass = MailDataProvider.class, dataProvider = "mailDataProvider")
    public void selectDraftTest(String addressee, String subject, String body){
        new MainPage().composeDraft().saveDraft(EmailUtils.createEmail(addressee, subject, body));
        DraftPage draftPage = new MainPage().openDraftsFolder().openDraftMessageByKeys();
        Assert.assertEquals(draftPage.readBody(), body, "Invalid body");
    }
}

package com.epam.elena_bolotova.mentoring.task9.tests.classic_tests;

import com.epam.elena_bolotova.mentoring.task9.framework.util.EmailUtils;
import com.epam.elena_bolotova.mentoring.task9.tests.classic_tests.dataproviders.MailDataProvider;
import com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages.DraftsPage;
import com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropDraftTest extends BaseTest {
        @Test(groups = {"needLogin"}, description = "Drag and drop draft message from Drafts to Inbox",
                dataProviderClass = MailDataProvider.class, dataProvider = "mailDataProvider")
        public void dragAndDropDraft(String addressee, String subject, String body){
            MainPage mainPage = new MainPage();
            mainPage.composeDraft().fillDraft(EmailUtils.createEmail(addressee, subject, body)).saveDraft();

            DraftsPage draftsPage = mainPage.openDraftsFolder();
            draftsPage.dragAndDropDraftToInbox();

            Assert.assertTrue(draftsPage.isAlertAppeared(), "Draft has not been moved");
        }


}

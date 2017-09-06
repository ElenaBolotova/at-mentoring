package com.epam.elena_bolotova.mentoring.task9.tests;

import com.epam.elena_bolotova.mentoring.task9.framework.core.ui.driver.Driver;
import com.epam.elena_bolotova.mentoring.task9.framework.util.EmailUtils;
import com.epam.elena_bolotova.mentoring.task9.tests.gmail.dataproviders.MailDataProvider;
import com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages.DraftsPage;
import com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropDraftTest extends BaseTest {
        @Test(groups = {"needLogin"}, description = "Drag and drop draft message from Drafts to Inbox",
                dataProviderClass = MailDataProvider.class, dataProvider = "mailDataProvider")
        public void dragAndDropDraft(String addressee, String subject, String body){
            MainPage mainPage = new MainPage();
            mainPage.composeDraft().saveDraft(EmailUtils.createEmail(addressee, subject, body));

            DraftsPage draftsPage = mainPage.openDraftsFolder();
            draftsPage.dragAndDropDraftToInbox();

            Assert.assertTrue(draftsPage.isAlertAppeared(), "Draft has not been moved");
        }


}

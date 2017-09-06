package com.epam.elena_bolotova.mentoring.task6.pageobject;/*
 */

import com.epam.elena_bolotova.mentoring.task6.pageobject.dataproviders.MailDataProvider;
import com.epam.elena_bolotova.mentoring.task6.pageobject.pages.DraftsPage;
import com.epam.elena_bolotova.mentoring.task6.pageobject.pages.MainPage;
import com.epam.elena_bolotova.mentoring.task6.pageobject.reporting.MyLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropDraftTest extends BaseTest {
        @Test(groups = {"needLogin"}, description = "Drag and drop draft message from Drafts to Inbox",
                dataProviderClass = MailDataProvider.class, dataProvider = "mailDataProvider")
        public void dragAndDropDraft(String addressee, String subject, String body){
            MainPage mainPage = new MainPage(getDriver());
            mainPage.composeDraft().saveDraft(addressee, subject, body);

            DraftsPage draftsPage = mainPage.openDraftsFolder();
            draftsPage.dragAndDropDraftToInbox();

            Assert.assertTrue(draftsPage.isAlertAppeared(), "Draft has not been moved");
            MyLogger.info("Draft was successfully created and moved to Inbox");
        }


}

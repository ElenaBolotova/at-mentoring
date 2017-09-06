package com.epam.elena_bolotova.mentoring.task9.tests.cucumber_steps;

import com.epam.elena_bolotova.mentoring.task9.framework.util.EmailUtils;
import com.epam.elena_bolotova.mentoring.task9.framework.util.UserUtils;
import com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.testng.Assert;

public class DraftActionsSteps {
    private LoginPage _loginPage;
    private MainPage _mainPage;
    private DraftPage _draftPage;
    private DraftsPage _draftsPage;

    @Given("^I log in GMail as valid user$")
    public void logIn() {
            _loginPage = new LoginPage();
            _loginPage.open();
            _mainPage = _loginPage.logIn(UserUtils.createUser("tuser5500@gmail.com", "Mentoring"));
    }

    @When("^I create new draft message$")
    public void composeDraft() {
        _draftPage = _mainPage.composeDraft();
    }

    @When("^I fill draft message fields$")
    public void fillDraft() {
        _draftPage.fillDraft(EmailUtils.createEmail("elena_bolotova@epam.com", "Test email", "This is my test email for hometask #5."));
    }

    @Given("^I have draft message$")
    public void checkDraft() {
        Assert.assertNotNull(_draftPage, "draft is not created");
    }

    @When("^I press delete button in draft message$")
    public void deleteDraft() {
        _draftPage.deleteDraft();
    }

    @Then("^I should see message that draft is deleted$")
    public void verifyMessageDraftDeleted() {
        String expectedMessage = "Your message has been discarded.";
        Assert.assertEquals(_mainPage.getDraftDiscardMessage(), expectedMessage, "Draft hasn't been deleted");
    }

    @Then("^draft message should not be in Drafts folder$")
    public void checkDraftNotInDrafts() {
        _draftsPage = _mainPage.openDraftsFolder();
        Assert.assertTrue(_draftsPage.isDraftsFolderEmpty(), "Draft message hasn't been deleted");
    }

    @When("^I save draft message$")
    public void saveDraft() {
        _draftPage.saveDraft();
    }

    @When("^I open draft message from Drafts folder$")
    public void openDraftFromDrafts() {
        _draftsPage = _mainPage.openDraftsFolder();
        _draftPage = _draftsPage.openDraftMessage();
    }

    @When("^I send draft message$")
    public void sendDraft() {
        _draftPage.sendDraft();
    }

    @Then("^draft message should be in Sent Items folder$")
    public void checkDraftInSentItems() {
        Assert.assertTrue(_mainPage.openSentMailFolder().isDraftMessageExists(), "There is no draft message in Sent Mail");
    }
}
package com.epam.elena_bolotova.mentoring.task9.tests.cucumber_steps;

import com.epam.elena_bolotova.mentoring.task9.framework.util.UserUtils;
import com.epam.elena_bolotova.mentoring.task9.tests.business_objects.User;
import com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages.ErrorLoginPage;
import com.epam.elena_bolotova.mentoring.task9.tests.gmail.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class IncorrectLogInSteps {
    private LoginPage _loginPage;
    private ErrorLoginPage _errorLoginPage;

    @Given("^I open Login page$")
    public void navigateToLoginPage() {
        _loginPage = new LoginPage();
        _loginPage.open();
    }

    @When("^I enter (.+) and (.+)$")
    public void enterIncorrectCreds(String username, String password) {
        _errorLoginPage = _loginPage.incorrectLogIn(UserUtils.createUser(username, password));
    }

    @Then("^I should see message about wrong password$")
    public void verifyMessageWrongPassword() {
        String actualErrorMessage = _errorLoginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, "Wrong password. Try again.", "Incorrect error message");
    }

}

@draftTests

Feature: actions with draft message
  Background:
    Given I log in GMail as valid user
    And I create new draft message
    And I fill draft message fields

    Scenario: delete draft
      Given I have draft message
      When I press delete button in draft message
      Then I should see message that draft is deleted
      And draft message should not be in Drafts folder

    Scenario: send draft from Drafts folder
      Given I have draft message
      When I save draft message
      And I open draft message from Drafts folder
      And I send draft message
      Then draft message should not be in Drafts folder
      And draft message should be in Sent Items folder
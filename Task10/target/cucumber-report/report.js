$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ActionsWithDraft.feature");
formatter.feature({
  "line": 3,
  "name": "actions with draft message",
  "description": "",
  "id": "actions-with-draft-message",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@draftTests"
    }
  ]
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I log in GMail as valid user",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I create new draft message",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I fill draft message fields",
  "keyword": "And "
});
formatter.match({
  "location": "DraftActionsSteps.logIn()"
});
formatter.result({
  "duration": 6319655127,
  "status": "passed"
});
formatter.match({
  "location": "DraftActionsSteps.composeDraft()"
});
formatter.result({
  "duration": 477288126,
  "status": "passed"
});
formatter.match({
  "location": "DraftActionsSteps.fillDraft()"
});
formatter.result({
  "duration": 2477063731,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "delete draft",
  "description": "",
  "id": "actions-with-draft-message;delete-draft",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "I have draft message",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I press delete button in draft message",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I should see message that draft is deleted",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "draft message should not be in Drafts folder",
  "keyword": "And "
});
formatter.match({
  "location": "DraftActionsSteps.checkDraft()"
});
formatter.result({
  "duration": 45036,
  "status": "passed"
});
formatter.match({
  "location": "DraftActionsSteps.deleteDraft()"
});
formatter.result({
  "duration": 484700265,
  "status": "passed"
});
formatter.match({
  "location": "DraftActionsSteps.verifyMessageDraftDeleted()"
});
formatter.result({
  "duration": 165686717,
  "status": "passed"
});
formatter.match({
  "location": "DraftActionsSteps.checkDraftNotInDrafts()"
});
formatter.result({
  "duration": 661833882,
  "status": "passed"
});
formatter.after({
  "duration": 1860407079,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I log in GMail as valid user",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I create new draft message",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I fill draft message fields",
  "keyword": "And "
});
formatter.match({
  "location": "DraftActionsSteps.logIn()"
});
formatter.result({
  "duration": 9248689088,
  "status": "passed"
});
formatter.match({
  "location": "DraftActionsSteps.composeDraft()"
});
formatter.result({
  "duration": 657769887,
  "status": "passed"
});
formatter.match({
  "location": "DraftActionsSteps.fillDraft()"
});
formatter.result({
  "duration": 1212474218,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "send draft from Drafts folder",
  "description": "",
  "id": "actions-with-draft-message;send-draft-from-drafts-folder",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "I have draft message",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "I save draft message",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "I open draft message from Drafts folder",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I send draft message",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "draft message should not be in Drafts folder",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "draft message should be in Sent Items folder",
  "keyword": "And "
});
formatter.match({
  "location": "DraftActionsSteps.checkDraft()"
});
formatter.result({
  "duration": 28049,
  "status": "passed"
});
formatter.match({
  "location": "DraftActionsSteps.saveDraft()"
});
formatter.result({
  "duration": 301308088,
  "status": "passed"
});
formatter.match({
  "location": "DraftActionsSteps.openDraftFromDrafts()"
});
formatter.result({
  "duration": 2556913118,
  "status": "passed"
});
formatter.match({
  "location": "DraftActionsSteps.sendDraft()"
});
formatter.result({
  "duration": 610452215,
  "status": "passed"
});
formatter.match({
  "location": "DraftActionsSteps.checkDraftNotInDrafts()"
});
formatter.result({
  "duration": 502978564,
  "status": "passed"
});
formatter.match({
  "location": "DraftActionsSteps.checkDraftInSentItems()"
});
formatter.result({
  "duration": 2680854897,
  "status": "passed"
});
formatter.after({
  "duration": 1776170142,
  "status": "passed"
});
});
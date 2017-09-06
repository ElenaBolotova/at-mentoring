@loginTests

Feature: user can not log in with incorrect credentials
  Scenario Outline: log in with incorrect password
    Given I open Login page
    When I enter <name> and <password>
    Then I should see message about wrong password

    Examples:
      |name| login|
      |tuser5500@gmail.com    |123456          |
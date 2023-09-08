Feature: OrangeHRM Leave page testing

  Background: Access the url
    Given I access https://opensource-demo.orangehrmlive.com/web/index.php/auth/login page

  Scenario: As a user I want to check if the Individual Employee is ticked in Add Leave Entitlement page
    Given I enter the valid login credentials
    And I press the Login button to log into my account
    When I click the Leave link
    And I choose to select Add Leave Entitlement from the Entitlements section
    Then I can see the Individual Employee button is checked by default in the Add to section

  Scenario: As a user I can verify that the Rejected status is correctly added to the leave records search
    Given I enter the valid login credentials
    When I press the Login button to log into my account
    And I click the Leave link
    And I select the Rejected status from the 'Show Leave with Status' section
    Then I check that the Rejected status is present as a selection by using XPath locator
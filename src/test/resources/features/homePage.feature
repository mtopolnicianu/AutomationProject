Feature: OrangeHRM Home page testing

  Background: Access the url
    Given I access https://opensource-demo.orangehrmlive.com/web/index.php/auth/login page
@test
  Scenario: As a user I can verify that the Rejected status is correctly added to the leave records search
    Given I enter the valid login credentials
    When I press the Login button to log into my account
#    And I click the Leave link on the menu
#    And I select the Rejected status from the 'Show Leave with Status' section
#    Then I check that the Rejected status is present as a selection by using XPath locator

  Scenario: As a user I am able to see the version on the home page
    Given I enter the valid login credentials
    And I press the Login button to log into my account
    Then I check the Help button to be displayed

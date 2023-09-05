Feature: OrangeHrm Admin page testing

  Background: Access the url
    Given I access https://opensource-demo.orangehrmlive.com/web/index.php/auth/login page

  Scenario: As a user I want to validate with title name that I am redirected to the correct page when I access the Admin link
    Given I enter the valid login credentials
    And I press the Login button to log into my account
    And I click the Admin link
    Then I verify that the title text is displayed correctly

  Scenario: As a user I want to validate with title name that I am redirected to the correct page when I access the Admin link
    Given I enter the valid login credentials
    And I press the Login button to log into my account
    And I click the Admin link
    Then I check that when I clicked on the Admin link it also shows the User Management text below the Admin text
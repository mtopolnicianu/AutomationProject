Feature: OrangeHrm login page testing

  Background: Access the url
    Given I access https://opensource-demo.orangehrmlive.com/web/index.php/auth/login page

  Scenario: As a user I want to log into my account with valid credentials
    Given I enter the valid login credentials
    And I press the Login button to log into my account
    Then I verify that I am logged into my account by checking that the username is displayed in the navigation bar in the right corner of the application


    Scenario: As a user I want to log into my account with invalid credentials
      Given I enter the invalid login credentials
      And I press the Login button to log into my account
      Then I verify that an appropriate message is displayed for invalid credentials


      Scenario: As a user I want to login with an empty username
        Given I enter the valid password without a username
        And I press the Login button to log into my account
        Then I verify that an appropriate message is displayed required field

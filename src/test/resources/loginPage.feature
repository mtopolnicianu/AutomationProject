Feature: OrangeHrm login page testing

  Background: Access the url
    Given I access https://opensource-demo.orangehrmlive.com/web/index.php/auth/login page

  Scenario: As a user I want to verify that my username field is empty when I open the login page
    Given I access https://opensource-demo.orangehrmlive.com/web/index.php/auth/login page
    Then I verify that the username and password field are displayed on the login page

  Scenario: As a user I want to log into my account with valid credentials
    Given I enter the valid login credentials
    And I press the Login button to log into my account
    Then I verify that I am logged into my account by checking that the username is displayed in the navigation bar in the right corner of the application


  Scenario: As a user I want to log into my account with invalid credentials
    Given I enter the invalid login credentials
    And I press the Login button to log into my account
    Then I verify that an appropriate message is displayed for invalid credentials


  Scenario: As a user I want to login without an username
    Given I enter the valid password without a username
    And I press the Login button to log into my account
    Then I verify that an appropriate message is displayed required username field

  Scenario: As a user I want to login without a password
    Given I enter the valid username without a password
    And I press the Login button to log into my account
    Then I verify that an appropriate message is displayed required password field

  Scenario: As a user I am able to see the version on the home page
    Given I enter the valid login credentials
    And I press the Login button to log into my account
    Then I check the Help button to be displayed

  Scenario: As a user I want to check if the Individual Employee is ticked in Add Leave Entitlement page
    Given I enter the valid login credentials
    And I press the Login button to log into my account
    And I click the Leave link
    And I choose to select Add Leave Entitlement from the Entitlements section
    Then I can see the Individual Employee button is checked by default in the Add to section

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

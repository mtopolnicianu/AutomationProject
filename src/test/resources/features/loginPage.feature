Feature: OrangeHRM login page testing

  Background: Access the url
    Given I access https://opensource-demo.orangehrmlive.com/web/index.php/auth/login page

  Scenario: As a user I want to verify that my username field is empty when I open the login page
    Given I access https://opensource-demo.orangehrmlive.com/web/index.php/auth/login page
    Then I verify that the username and password field are displayed on the login page

  Scenario: As a user I want to validate the logo
    Given I access https://opensource-demo.orangehrmlive.com/web/index.php/auth/login page
    Then I verify that the company logo is displayed on the login page

  Scenario Outline: Check login is successful with valid credentials
    Given I enter <username> and <password>
    And I press the Login button to log into my account
    Then I verify that I am logged into my account by checking that the username is displayed in the navigation bar in the right corner of the application

    Examples:
      | username | password |
      | Admin    | admin123 |

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








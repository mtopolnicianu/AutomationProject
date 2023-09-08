Feature: OrangeHrm Admin page testing

  Background: Access the url
    Given I access https://opensource-demo.orangehrmlive.com/web/index.php/auth/login page

  Scenario: As a user I want to validate with title name that I am redirected to the correct page when I access the Admin link
    Given I enter the valid login credentials
    When I press the Login button to log into my account
    And I click the Admin link
    Then I verify that the title text is displayed correctly

  Scenario: As a user I want to validate with title name that I am redirected to the correct page when I access the Admin link
    Given I enter the valid login credentials
    When I press the Login button to log into my account
    And I click the Admin link
    Then I check that when I clicked on the Admin link it also shows the User Management text below the Admin text

  Scenario: As a user I am able to access the Language Packages
    Given I enter the valid login credentials
    When I press the Login button to log into my account
    And I click the Admin link
    And I click on the Configuration dropdown menu button
    And I click on the Language Packages option
    And I click on the Translate button for Spanish - Español language package
    Then I should be redirected to the languageCustomization page

  Scenario: As a user I am able to add a new language Package
    Given I enter the valid login credentials
    When I press the Login button to log into my account
    And I click the Admin link
    And I click on the Configuration dropdown menu button
    And I click on the Language Packages option
    And I click the Add button to add a new language to the packages
    And I select the language Colognian Germany from that list
#    And I press the Save to add this new language to my packages
#    Then I should be able txo see the confirmation message that the language was successfully saved
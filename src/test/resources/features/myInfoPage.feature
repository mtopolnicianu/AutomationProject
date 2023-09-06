Feature: OrangeHRM MyInfo page testing

  Background: Access the url
    Given I access https://opensource-demo.orangehrmlive.com/web/index.php/auth/login page

    Scenario: As a user I am able to update my street and country details
      Given I enter the valid login credentials
      And I press the Login button to log into my account
      And I click the My Info link
      And I click on the Contact Details link which will redirect me to the contactDetails page
      And I update the Street 1 field from contact details
      And I select Algeria as country
      And I press the Save button
      Then I should see the successfully updated confirmation message
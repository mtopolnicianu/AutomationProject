Feature: OrangeHrm website testing

Scenario:
   Given I access https://opensource-demo.orangehrmlive.com/web/index.php/auth/login page
   And I enter the valid login credentials
   And I press the Login button to log into my account
   Then I verify that I am logged into my account by checking that the username is displayed in the navigation bar in the right corner of the application
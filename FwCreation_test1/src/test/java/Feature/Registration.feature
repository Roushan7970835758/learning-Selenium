Feature:To Validate the working of Register Account functionality

Background:
Given launch the openCart application
Then Read the cookies form "cookie.data"
Then validate the home page

@TC_RF_001
Scenario: Validate Registering an Account by providing only the Mandatory fields
Given I click on the 'My Account' drop menu
    And I click on the 'Register' option
    And I enter the following mandatory account details:
      | Field             | Value             |
      | First Name        | TestFirst         |
      | Last Name         | TestLast          |
      | E-Mail            | test_4@example.com |
      | Password          | password123       |
    And I click on the 'Continue' button
    And I click on the 'Continue' button displayed on the 'Account Success' page
    Then I should be logged in and taken to the 'My Account' page





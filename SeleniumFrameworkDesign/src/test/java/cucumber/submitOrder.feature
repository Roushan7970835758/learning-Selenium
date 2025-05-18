@tag
Feature: Purchase the order from the ecomerse website
    
    Background:
    Given I landed on Ecomerce page

  @Regression
  Scenario Outline:Positive Test for Submiting the order
    Given login using the username <name> and password <password>
    When I add product <productName> from kart
    And  Checkout product <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." Message displayed on ComformationPage

    Examples: 
      | name              | password    | productName         |
      | roushan@gmail.com | Roushan@123 | ROUSHAN VERMA2   		|
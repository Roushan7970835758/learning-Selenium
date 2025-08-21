
@tag
Feature: Naukri.com Automation
  Naukri.com Auto Update resume , skill Serch, Auto filterJob, Auto Apply for jobs
  
  @Background:
  Given I navigate to Naukri Application
  And   I logIn By my Credentials

  

  @tag1
  Scenario Outline: Updating  Resume 
    Given I am on home page of my profile
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |

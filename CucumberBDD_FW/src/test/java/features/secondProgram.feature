
@tag
Feature: Application Login

Background: 
Given setup the entires in database
When launch the browser from config variables
And hit the home page url of banking site

Scenario: Admin Page default login

Given User is on NetBanking landing page
When User login into application with admin and password 1234    #regex is implemented here
Then Home page is displayed
And Cards are displayed

Scenario Outline: User Page default login

Given User is on NetBanking landing page
When User login into application with "<username>" and password "<password>"
Then Home page is displayed
And Cards are displayed

Examples:
	|username|password|
	|user    |2342		|
	|user2   |2342    |
	
@smokeTest
Scenario: User Page default Sign up

Given User is on Practice landing page
When User login into application 
|Roushan|
|Kumar|
|roushankumar22145@gmail.com|
|7970835757|
Then Home page is displayed
And Cards are displayed

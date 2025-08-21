Feature: Validating Place APIs
@AddPlace @regression
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
    Given add place payload "<Name>" "<Language>" "<Address>"
    When user calls "AddPlaceAPI" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And Varify placeId Created mapped to "<Name>" using "GetPlaceAPI"

Examples:
    | Name          | Language | Address       |
    | Roushan Kumar | English  | Patna, Bihar  |
   # |Rahul Verma	|Hindi		|sitamari, Bihar|
@deletePlace @regression
Scenario: Vafify if place is being successfully deleted using DeletePlaceAPI
  Given Delete place Payload
  When user calls "DeletePlaceAPI" with "DELETE" http request
  Then the API call got success with status code 200
  And "status" in response body is "OK"
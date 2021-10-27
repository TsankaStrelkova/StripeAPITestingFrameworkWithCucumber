Feature: Stripe Create Customer API
  Validate Stripe Create Customer API

  Scenario: Validate Create Customer API with valid key,email, description
    Given I set the valid aut key
    And I set "tsanka@tsanka.com" as the email parameter
    And I set "Description for tsanka com" as the description parameter
    When I send a post request to customer API
    Then I should get 200 as the expected status code
    And I should have "id" field in the response
    And I should get  "tsanka@tsanka.com" as  email in the response
    And I should get "Description for tsanka com" as description in the response

  #Scenario Outline: Validate Create Customer API with invalid email
    #Given I set the valid aut key
    #And I set "<email>" as the email parameter
    #And I set "<description>" as the description parameter
    #When I send a post request to "<url>"
    #Then I should get <expectedStatusCode> as the expected status code
    #And I should have "<expectedFieldToPresentInTheResponse>" field in the response
    #And I should get  "<expectedStatusEmail>" as  email in the response
    #And I should get "<expectedStatusDescription>" as description in the response
#
    #Examples: 
      #| email          | description                | url                                 | expectedStatusCode | expectedFieldToPresentInTheResponse | expectedStatusEmail | expectedStatusDescription     |
      #| demo@email.com | Description fro dummy user | https://api.stripe.com/v1/customers |                200 | id                                  | demo@email.com      | Description fro dummy user    |

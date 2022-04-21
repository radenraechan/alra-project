Feature: Authorized
  As an admin
  I want to authorize user
  So that I can access the detail data user

  # Scenario 3.1: Positive
  Scenario: POST - As an admin I have to be able to authorize user
    Given I set an endpoint for POST authorize user
    When I request POST authorize user
    Then I validate the status code for account is 200
    And validate the data detail after authorize user

  # Scenario 3.2: Negative
  Scenario: POST - As an admin I can't authorize user with invalid input password
    Given I set an endpoint for POST authorize user
    When I request POST authorize user with invalid input password
    Then I validate the status code for account is 404
    And validate the data detail after failed authorize user with invalid input password

  # Scenario 3.3: Negative
  Scenario: POST - As an admin I can't authorize user with null input password
    Given I set an endpoint for POST authorize user
    When I request POST authorize user with null input password
    Then I validate the status code for account is 400
    And validate the data detail after failed authorize user with null input password
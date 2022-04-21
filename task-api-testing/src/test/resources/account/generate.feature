Feature: GenerateToken
  As an admin
  I want to generate token user
  So that I can access the detail data user

  # Scenario 2.1: Positive
  Scenario: POST - As an admin I have to be able to generate token user
    Given I set an endpoint for POST new generate token user
    When I request POST generate token user
    Then I validate the status code for account is 200
    And validate the data detail after generate token user
    And get token for other request

  # Scenario 2.2: Negative
  Scenario: POST - As an admin I can't generate token user with invalid input password
    Given I set an endpoint for POST new generate token user
    When I request POST generate token user with invalid input password
    Then I validate the status code for account is 200
    And validate the data detail after failed generate token user

  # Scenario 2.3: Negative
  Scenario: POST - As an admin I can't generate token user with null input password
    Given I set an endpoint for POST new generate token user
    When I request POST generate token user with null input password
    Then I validate the status code for account is 400
    And validate the data detail after failed generate token user with null input password
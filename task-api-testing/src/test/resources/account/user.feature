Feature: User
  As an admin
  I want to create new user
  So that I can access the detail data user

  # Scenario 1.1: Positive
  Scenario: POST - As an admin I have to be able to create new user
    Given I set an endpoint for POST new user
    When I request POST detail user
    # Then I validate the status code is 201
    Then validate the data detail after create user
    And get userId for other request

  # Scenario 1.2: Negative
  Scenario: POST - As an admin I can't create new user that have existed
    Given I set an endpoint for POST new user
    When I request POST detail user that have same userName and same password
    Then I validate the status code for account is 406
    And validate the data detail after failed create user
    And get code for validate

  # Scenario 1.3: Negative
  Scenario: POST - As an admin I can't create new user with invalid input password
    Given I set an endpoint for POST new user
    When I request POST detail user with invalid input password
    Then I validate the status code for account is 400
    And validate the data detail after failed create user
    And get code for validate

  # Scenario 1.4: Negative
  Scenario: POST - As an admin I can't create new user with null input password
    Given I set an endpoint for POST new user
    When I request POST detail user with null input password
    Then I validate the status code for account is 400
    And validate the data detail after failed create user

  # Scenario 4.1: Positive
  Scenario: GET - As an admin I have to be able to get detail user
    Given I set an endpoint for GET detail user
    When I request GET detail user
    Then I validate the status code for account is 200
    And validate the data detail

  # Scenario 4.2: Negative
#  Scenario: GET - As an admin I can't get detail user without authorized
#    Given I set an endpoint for GET detail user
#    When I request GET detail user without authorized
#    Then I validate the status code is 401
#    And validate the data detail without authorized

  # Scenario 4.3: Negative
#  Scenario: GET - As an admin I can't get detail user with invalid input userId
#    Given I set an endpoint for GET detail user
#    When I request GET detail user with invalid input userId
#    Then I validate the status code is 401
#    And validate the data detail with invalid input userId

  # Scenario 5.1: Positive
  Scenario: DELETE - As an admin I have to be able to delete user
    Given I set an endpoint for DELETE user
    When I request DELETE user
    Then I validate the status code for account is 200
    And validate the data detail after delete user

  # Scenario 5.2: Negative
#  Scenario: DELETE - As an admin I can't delete user without authorized
#    Given I set an endpoint for DELETE user
#    When I request DELETE user without authorized
#    Then I validate the status code is 401
#    And validate the data detail after delete user without authorized

  # Scenario 5.3: Negative
#  Scenario: DELETE - As an admin I can't delete user with invalid input userId
#    Given I set an endpoint for DELETE user
#    When I request DELETE user with invalid input userId
#    Then I validate the status code is 401
#    And validate the data detail after delete user with invalid input userId
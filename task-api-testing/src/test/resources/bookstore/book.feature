Feature: Bookstore
  As an admin
  I want to get and delete data books
  So that I can access the details data books

  # Scenario 3.1: Positive
  Scenario: GET - As an admin I have to be able to get detail book
    Given I set an endpoint for GET detail book
    When I request GET detail book
    Then I validate the status code is 200
    And validate the data detail book

  # Scenario 3.2: Negative
  Scenario: GET - As an admin I can't get detail book with input invalid ISBN
    Given I set an endpoint for GET detail book with input invalid ISBN
    When I request GET detail book with input invalid ISBN
    Then I validate the status code is 400
    And validate the data detail book with input invalid ISBN

  # Scenario 3.3: Negative
  Scenario: GET - As an admin I can't get detail book with input null ISBN
    Given I set an endpoint for GET detail book with input null ISBN
    When I request GET detail book with input null ISBN
    Then I validate the status code is 400
    And validate the data detail book with input null ISBN

  # Scenario 4.1: Positive
  Scenario: DELETE - As an admin I have to be able to delete book
    Given I set an endpoint for DELETE book
    When I request DELETE book
    Then I validate the status code is 200
    And validate the data detail after delete book

  # Scenario 4.2: Negative
  Scenario: DELETE - As an admin I can't delete book without authorized
    Given I set an endpoint for DELETE book
    When I request DELETE book without authorized
    Then I validate the status code is 401
    And validate the data detail after failed delete book without authorized

  # Scenario 4.3: Negative
  Scenario: DELETE - As an admin I can't delete book with invalid userId
    Given I set an endpoint for DELETE book
    When I request DELETE book with invalid userId
    Then I validate the status code is 401
    And validate the data detail after failed delete book with invalid userId

  # Scenario 4.4: Negative
  Scenario: DELETE - As an admin I can't delete book with invalid ISBN
    Given I set an endpoint for DELETE book
    When I request DELETE book with invalid ISBN
    Then I validate the status code is 400
    And validate the data detail after failed delete book with invalid ISBN
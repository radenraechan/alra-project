Feature: Bookstore
  As an admin
  I want to CRUD data books
  So that I can access the details data books

  # Scenario 1.1: Positive
#  Scenario: POST - As an admin I have to be able to get books
#    Given I set an endpoint for POST get book
#    When I request POST detail book
#    Then I validate the status code is 201
#    And validate the data detail book

  # Scenario 1.2: Negative
#  Scenario: POST - As an admin I can't get books without authorized
#    Given I set an endpoint for POST get book
#    When I request POST detail book without authorized
#    Then I validate the status code is 401
#    And validate the data detail after failed get book without authorized

  # Scenario 1.3: Negative
#  Scenario: POST - As an admin I can't get book with invalid input userId
#    Given I set an endpoint for POST get book
#    When I request POST detail book with invalid input userId
#    Then I validate the status code is 401
#    And validate the data detail after failed get book with invalid input userId

  # Scenario 1.4: Negative
#  Scenario: POST - As an admin I can't get book with invalid input ISBN
#    Given I set an endpoint for POST get book
#    When I request POST detail book with invalid input ISBN
#    Then I validate the status code is 400
#    And validate the data detail after failed get book with invalid input ISBN

  # Scenario 2.1: Positive
#  Scenario: DELETE - As an admin I have to be able to delete books with UserId
#    Given I set an endpoint for DELETE books
#    When I request DELETE books
#    Then I validate the status code is 204
#    And validate the data detail after delete books

  # Scenario 2.2: Negative
#  Scenario: DELETE - As an admin I can't delete books without authorized
#    Given I set an endpoint for DELETE books
#    When I request DELETE books without authorized
#    Then I validate the status code is 401
#    And validate the data detail after failed delete books without authorized

  # Scenario 2.3: Negative
#  Scenario: DELETE - As an admin I can't delete books with invalid input userId
#    Given I set an endpoint for DELETE books
#    When I request DELETE books with invalid input userId
#    Then I validate the status code is 401
#    And validate the data detail after failed delete books with invalid input userId

  # Scenario 5.1: Positive
  Scenario: PUT - As an admin I have to be able to update detail books
    Given I set an endpoint for PUT detail books
    When I request PUT detail books
    # Then I validate the status code is 200
    And validate the data detail books

  # Scenario 5.2: Negative
  Scenario: PUT - As an admin I can't update detail books without authorized
    Given I set an endpoint for PUT detail books
    When I request PUT detail books without authorized
    # Then I validate the status code is 401
    And validate the data detail books without authorized

  # Scenario 5.3: Negative
  Scenario: PUT - As an admin I can't update detail books with invalid input ISBN
    Given I set an endpoint for PUT detail books
    When I request PUT detail books with invalid input ISBN
    # Then I validate the status code is 400
    And validate the data detail books with invalid input ISBN

  # Scenario 5.4: Negative
  Scenario: PUT - As an admin I can't update detail books with invalid replaced new ISBN
    Given I set an endpoint for PUT detail books
    When I request PUT detail books with invalid replaced new ISBN
    # Then I validate the status code is 400
    And validate the data detail books with invalid replaced new ISBN

  # Scenario 5.5: Negative
  Scenario: PUT - As an admin I can't update detail books with invalid input userId
    Given I set an endpoint for PUT detail books
    When I request PUT detail books with invalid input userId
    # Then I validate the status code is 400
    And validate the data detail books with invalid input userId





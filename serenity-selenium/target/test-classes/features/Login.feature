Feature: Login
  As a user
  I want to login
  So that I can access book page

  Scenario: As a user I have to be able to login
    Given I am on the bookstore page
    When I click login button
    And input valid username
    And input valid password
    And click login button
    Then I will direct to profile page
#
  Scenario: As a user I can't login with invalid password
    Given I am on the bookstore page
    When I click login button
    And input valid username
    And input invalid password
    And click login button
    Then Page will show an error message "Invalid username or password!"
#
#  Scenario: As a user I can't login with invalid username
#    Given I am on the bookstore page
#    When I click login button
#    And input invalid username
#    And input valid password
#    And click login button
#    Then Page will show an error message "Invalid username or password!"
#
#  Scenario: As a user I can't login with invalid username and invalid password
#    Given I am on the bookstore page
#    When I click login button
#    And input invalid username
#    And input invalid password
#    And click login button
#    Then Page will show an error message "Invalid username or password!"

#  Background:
#    Given I am on the bookstore page
#    And I click login button
#
#  @DDT
#  Scenario Outline: Login scenario
#    When input "<userName>" userName
#    And input "<password>" password
#    And click register button
#    Then I get the "<result>"
#    Examples:
#      |userName|password|result|
#      |        |        |icon warning|
#      |        |Password1*|icon warning|
#      |string|        |icon warning|
#      |string|String1|Epic sadface: Invalid username or password!|
#      |string|String1*|page profile|
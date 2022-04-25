Feature: Register
  As a user
  I want to register / create a new account
  So that I can login

#  Scenario: As a user I have to be able to register
#    Given I am on the bookstore page
#    When I click login button
#    And click new user button
#    And input valid first name
#    And input valid last name
#    And input valid username
#    And input valid password
#    And click validate captcha
#    And click register button
#    Then I will direct to profile page

#  Background:
#    Given I am on the bookstore page
#    And I click login button
#    And click new user button
#
#  @DDT
#  Scenario Outline: Register scenario
#    When I input "<firstName>" firstName
#    And I input "<lastName>" lastName
#    And I input "<userName>" userName
#    And I input "<password>" password
#    And click register button
#    Then I get the "<result>"
#    Examples:
#      |firstName|lastName|userName|password|result|
#      |         |        |        |        |icon warning|
#      |         |        |        |Password1*|icon warning|
#      |         |        |username|        |icon warning|
#      |         |Last    |        |        |icon warning|
#      |First    |        |        |        |icon warning|
#      |First    |Last    |username|Password1*|direct to page profile|
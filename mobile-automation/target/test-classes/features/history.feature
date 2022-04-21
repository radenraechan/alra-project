Feature: History

  Scenario: See history
    Given I am on calculator page
    When I click history button
    Then I get the result of history

  Scenario: Delete history
    Given I am on calculator page
    When I click history button
    And I click delete button
    Then I get the result after delete history
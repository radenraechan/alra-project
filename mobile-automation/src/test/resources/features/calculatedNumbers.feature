Feature: Calculated Numbers

  Scenario Outline: Adding two numbers
    Given I am on calculator page
    When I click "<number1>"
    And I click addition symbol
    And I click "<number2>"
    Then I get the result is "<result>"
    Examples:
      |number1|number2|result|
      |1      |2      |3     |
      |5      |10     |15    |
      |25     |100    |125   |

  Scenario Outline: Substracting two numbers
    Given I am on calculator page
    When I click "<number1>"
    And I click substract symbol
    And I click "<number2>"
    Then I get the result is "<result>"
    Examples:
      |number1|number2|result|
      |2      |1      |1     |
      |10     |5      |5     |
      |100    |25     |75    |

  Scenario Outline: Multiplying two numbers
    Given I am on calculator page
    When I click "<number1>"
    And I click multiply symbol
    And I click "<number2>"
    Then I get the result is "<result>"
    Examples:
      |number1|number2|result|
      |1      |2      |2     |
      |5      |10     |50    |
      |25     |100    |2500  |

  Scenario Outline: Dividing two numbers
    Given I am on calculator page
    When I click "<number1>"
    And I click divide symbol
    And I click "<number2>"
    Then I get the result is "<result>"
    Examples:
      |number1|number2|result|
      |2      |1      |2     |
      |10     |5      |2     |
      |100    |2      |50    |
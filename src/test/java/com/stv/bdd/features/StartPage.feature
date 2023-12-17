Feature: Start page testing

  Scenario: 01. Open the start page
    Given Start page is opened by default
    When The user enters CYCLE into the search
    Then A query appeared in the search
    And Search results are displayed

    Scenario: 011. Clearing the form
      When User clears search
      Then Search is empty

Scenario: 02.Go to help page
  Given Start page is opened by default
  When User asks for help
  Then The user went to the help page

  Scenario Outline: 021. Search in help
    When User enters <words>
    Then A request appeared while searching for help
    Examples:
      |words  |
      |login  |
      |account|
  Scenario: 022. Search in help
    When Started a search
    Then Search results are displayed help

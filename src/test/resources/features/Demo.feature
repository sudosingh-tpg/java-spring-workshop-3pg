@Demo

Feature: This is a demo feature file

  Scenario: This is a demo test

    Given I navigate to Selenium Easy web page
    When I open the 'Input Forms' dropdown
    And I select a Simple Form Demo
    Then the simple form is displayed
    When I input a text in the Simple Input Field
    And I click 'Show Message' button
    Then my text is displayed
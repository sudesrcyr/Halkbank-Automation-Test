Feature: Live Help Functionality

  Scenario: Observing bug in the live help
    Given user opens page
    And scroll down to the bottom
    When click live help chat bubble
    And select an option and click start the conversation
    And  enter the information in the form
    And click continue and see the error message because of invalid data input
    And click to the back
    Then choose another option and see the bug
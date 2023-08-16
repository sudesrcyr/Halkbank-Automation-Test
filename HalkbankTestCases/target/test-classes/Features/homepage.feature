Feature: Homepage Feature

  Scenario: transact with invalid data
    Given user goes to link
    And user scroll down the page
    And user click the any credit type
    And click the select-box
    When user fills the first box
    And user fills the second box
    And click the button
    And user click the next button
    And user enter the information
    Then user clicks continue and get an error message

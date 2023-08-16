Feature: branch/atm search
  Scenario: checks the branch/atm search works properly
    Given user goes to the website
    And user scrolls down the page to the bottom
    And user clicks on the branch atm search
    And scroll down the new page again
    And user clicks on the from list
    When user clicks on the atm
    And user clicks on the first combobox and select any city
    And user clicks on the second combobox and select any county
    And user clicks on the third combobox and select any branch type
    And user clicks on the fourth combobox and select any option
    Then user clicks on the search and see the result on the right side
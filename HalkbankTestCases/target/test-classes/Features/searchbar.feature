Feature: Searchbar Functionality

  Scenario: the functionality of searching with valid keyword

    Given user goes to homepage
    And user clicks the searchbar
    When user fills the search box with keyword or sentence
    Then user clicks enter
    And scroll down the page
    And  go another page and click on the title



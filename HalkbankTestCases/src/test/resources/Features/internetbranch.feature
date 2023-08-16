Feature:Internet Branch Functionality

  Scenario:Check the internet branch with invalid data
    Given user goes bank page
    And user click internet branch
    And user click retail
    When user fills in the identity number
    And user fills in the password
    Then user click the login button and sees the error message
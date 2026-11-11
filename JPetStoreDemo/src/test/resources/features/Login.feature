Feature: Login functionality
  Scenario Outline: Verify user login
    Given user is on the JPetStore home page
    When user clicks on Sign In
    And user logs in using credentials for test "<TestID>"
    Then user should be logged in successfully
 
    Examples:
      | TestID |
      | L001   |
      | L002   |
      | L003   |
      | L004   |
      | L005   |
    Scenario: Verify user can sign out
 
    Given user is on the JPetStore home page
    When user clicks on Sign In
    And user logs in using credentials for test "L001"
    And user clicks on Sign Out
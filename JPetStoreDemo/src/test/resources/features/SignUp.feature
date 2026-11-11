Feature: Sign Up functionality
  Scenario Outline: Verify user registration
    Given user is on the JPetStore home page
    When user clicks on Sign In for registration
    And user clicks on Register Now
    And user enters registration details for "<UserID>"
 
    Examples:
      | UserID |
      | S001   |
      | S002   |
      | S003   |
      | S004   | 
      | S005   | 
      | S006   | 
      | S007   |
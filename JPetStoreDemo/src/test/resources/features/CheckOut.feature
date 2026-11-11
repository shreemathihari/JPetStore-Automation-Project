Feature: Checkout functionality
 
Scenario Outline: Verify user can enter checkout details
 
    Given user is on the JPetStore home page
    When user clicks on Sign In
    And user adds the product for cart test "C001"
    And user opens the cart for checkout
    And user proceeds to checkout
    And user logs in using credentials for test "L001"
    And user enters checkout details for "<TestID>"
    And user clicks continue on checkout
 
Examples:
    | TestID |
    | CH001  |
    | CH002  |
    | CH003  |
    | CH004  |
    | CH005  |
    | CH006  |
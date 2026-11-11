Feature: Cart functionality
Scenario Outline: Verify user can add product to cart

    Given user is on the JPetStore home page
    When user clicks on Sign In
    And user logs in using credentials for test "L001"
    And user adds the product for cart test "<TestID>"

Examples:
    | TestID |
    | C001   |
    | C002   |
    | C003   |
    | C004   |
    | C005   |
    | C006   |
    | C007   |
    | C008   |
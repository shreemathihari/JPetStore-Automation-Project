Feature: Product functionality
Scenario Outline: Verify user can view product category
 
    Given user is on the JPetStore home page
    When user selects the category for test "<TestID>"
 
Examples:
    | TestID |
    | P001   |
    | P002   |
    | P003   |
    | P004   |
    | P005   |
 
 
Scenario Outline: Verify user can view product details
 
    Given user is on the JPetStore home page
    When user selects the category for test "<TestID>"
    And user selects the product for test "<TestID>"
 
Examples:
    | TestID |
    | P006   |
    | P007   |
    | P008   |
    | P009   |
    | P010   |
 
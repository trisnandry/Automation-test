Feature: Sorted Products
  Scenario: Sorted all products with A-Z
    Given user in login page
    When user login with valid credential
    And user selects sort option "Name (A to Z)"
    Then Then the product list should be displayed in ascending order by name

  Scenario: Sorted all products with Z-A
    Given user in login page
    When user login with valid credential
    And user selects sort option "Name (Z to A)"
    Then Then the product list should be displayed in descending order by name

  Scenario: Sorted all products with Price (low to high)
    Given user in login page
    When user login with valid credential
    And user selects sort option "Price (low to high)"
    Then Then the product list should be displayed in ascending order by price

  Scenario: Sorted all products with Price (high to low)
    Given user in login page
    When user login with valid credential
    And user selects sort option "Price (high to low)"
    Then Then the product list should be displayed in descending order by price
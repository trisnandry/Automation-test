Feature: Add Chart
  Scenario: Add chart one products
    Given user in login page
    When user login with valid credential
    And user click add to chart
    And user click chart
    Then Then the product exist in chart list
Feature: Checkout
  Scenario: Fill correct form when checkout
    Given user in login page
    When user login with valid credential
    And user click add to chart
    And user click chart
    And user click checkout
    And user fill valid frist name "udin"
    And user fill valid last name "jaidudin"
    And user fill valid zip code "15233"
    And user click continue
    And user click finish
    Then user get message success order "Thank you for your order!"

  Scenario: Fill empty first name
    Given user in login page
    When user login with valid credential
    And user click add to chart
    And user click chart
    And user click checkout
    And user fill valid last name "jaidudin"
    And user fill valid zip code "15233"
    And user click continue
    Then user get message error order "Error: First Name is required"
  Scenario: Fill empty last name
    Given user in login page
    When user login with valid credential
    And user click add to chart
    And user click chart
    And user click checkout
    And user fill valid frist name "udin"
    And user fill valid zip code "15233"
    And user click continue
    Then user get message error order "Error: Last Name is required"
  Scenario: Fill empty zip code
    Given user in login page
    When user login with valid credential
    And user click add to chart
    And user click chart
    And user click checkout
    And user fill valid frist name "udin"
    And user fill valid last name "jaidudin"
    And user click continue
    Then user get message error order "Error: Postal Code is required"

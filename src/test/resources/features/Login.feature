Feature: Login
  Scenario: Login with valid credential
    Given user in login page
    When user fill valid username "standard_user"
    And user fill valid password "secret_sauce"
    And user click button login
    Then user direct to dashboard page
  Scenario: Login with invalid username
    Given user in login page
    When user fill invalid username "invalid_user"
    And user fill valid password "secret_sauce"
    And user click button login
    Then user get error message
  Scenario: Login with invalid password
    Given user in login page
    When user fill valid username "standard_user"
    And user fill invalid password "invalid_password"
    And user click button login
    Then user get error message
  Scenario: Login with sql injection password
    Given user in login page
    When user fill valid username "` OR 1=1;/*"
    And user fill invalid password "*/--"
    And user click button login
    Then user get error message

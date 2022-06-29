Feature: Login feature

  Background:
    Given the user is on the welcome page

  Scenario: Login with valid credentials / AZ
    And chooses Azerbaijan
    Then the user lands to the home page
    And the user should see the country logo for Azerbaijan
    And the user clicks on the login button on the home page
    When the user logs with valid credentials
    Then the user should be able to login


  Scenario: Login with valid credentials / IS
    And chooses Israel
    Then the user lands to the home page
    Then the user should see the country logo for Israel
    And the user clicks on the login button on the home page
    When the user logs with valid credentials
    Then the user should be able to login


  Scenario: Login with invalid credentials / AZ
    And chooses Azerbaijan
    Then the user lands to the home page
    And the user clicks on the login button on the home page
    When the user logs in using invalid credentials
    Then the user should see the error message


  Scenario: Login with invalid credentials / IS
    And chooses Israel
    Then the user lands to the home page
    And the user clicks on the login button on the home page
    When the user logs in using invalid credentials
    Then the user should see the error message

  Scenario Outline: User can not login with any invalid credentials / AZ
    And chooses Azerbaijan
    Then the user lands to the home page
    And the user clicks on the login button on the home page
    When the user enters invalid credentials "<username>" and "<password>"
    Then the user should see the error message

    Examples:
      | username                | password |
      | paulinaberg1@gmail.comM | 12345678 |

  Scenario Outline: User can not login with any invalid credentials / IS
    And chooses Israel
    Then the user lands to the home page
    And the user clicks on the login button on the home page
    When the user enters invalid credentials "<username>" and "<password>"
    Then the user should see the error message

    Examples:
      | username                | password |
      | paulinaberg1@gmail.comM | 12345678 |

  Scenario: Verify default inputbox positions / AZ
    And chooses Azerbaijan
    Then the user lands to the home page
    And the user clicks on the login button on the home page
    Then the user should see the placeholders

  Scenario: Verify default inputbox positions / IS
    And chooses Israel
    Then the user lands to the home page
    And the user clicks on the login button on the home page
    Then the user should see the placeholders

  Scenario: Forgot password and reset password / AZ
    And chooses Azerbaijan
    Then the user lands to the home page
    And the user clicks on the login button on the home page
    Then the user click to forgot my password button
    Then enters the email adress and clicks continue
    And the user is able to see the validation message on the screen
















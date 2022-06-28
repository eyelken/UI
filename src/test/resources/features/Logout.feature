Feature: Log out feature

  Scenario: Log out function / AZ
    Given the user logs in successfully -az
    Then the user clicks on the log out button
    And the user is able to log out

  Scenario: Log out function / IS
    Given the user logs in successfully -is
    Then the user clicks on the log out button
    And the user is able to log out

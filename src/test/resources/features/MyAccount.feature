Feature: My Account feature

  Scenario: Updating profile name / AZ
    Given the user logs in successfully -az
    And the user clicks to the profile
    Then the user is able to land to the My Account
    And the user updates the name

  Scenario: Updating profile name / IS
    Given the user logs in successfully -is
    And the user clicks to the profile
    Then the user is able to land to the My Account
    And the user updates the name






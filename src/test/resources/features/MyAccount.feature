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

  Scenario: Updating gender as Female / AZ
    Given the user logs in successfully -az
    And the user clicks to the profile
    Then the user is able to land to the My Account
    And the user updates the gender as female

  Scenario: Updating gender as Female / IS
    Given the user logs in successfully -is
    And the user clicks to the profile
    Then the user is able to land to the My Account
    And the user updates the gender as female

  Scenario: Updating gender as Male / AZ
    Given the user logs in successfully -az
    And the user clicks to the profile
    Then the user is able to land to the My Account
    And the user updates the gender as male

  Scenario: Updating gender as Male / IS
    Given the user logs in successfully -is
    And the user clicks to the profile
    Then the user is able to land to the My Account
    And the user updates the gender as male

  Scenario: Updating gender as No answer / AZ
    Given the user logs in successfully -az
    And the user clicks to the profile
    Then the user is able to land to the My Account
    And the user updates the gender as no answer

  Scenario: Updating gender as No answer / IS
    Given the user logs in successfully -is
    And the user clicks to the profile
    Then the user is able to land to the My Account
    And the user updates the gender as no answer

  Scenario: Updating birthday date / AZ
    Given the user logs in successfully -az
    And the user clicks to the profile
    Then the user is able to land to the My Account
    And the user is changing the birthday date

  Scenario: Updating birthday date / IS
    Given the user logs in successfully -is
    And the user clicks to the profile
    Then the user is able to land to the My Account
    And the user is changing the birthday date

  Scenario: Updating the address / AZ
    Given the user logs in successfully -az
    And the user clicks to the profile
    Then the user is able to land to the My Account
    And the user is navigating to the Addresses
    Then the user is able to change the address

    @wip
  Scenario: Updating the address / IS
    Given the user logs in successfully -is
    And the user clicks to the profile
    Then the user is able to land to the My Account
    And the user is navigating to the Addresses
    Then the user is able to change the address







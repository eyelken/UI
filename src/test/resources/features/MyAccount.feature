Feature: My Account feature

  Background:
    Given the user is on the welcome page

    @wip
  Scenario: Updating profile
    And chooses Azerbaijan
    Then the user lands to the home page
    And the user clicks on the login button on the home page
    And the user clicks to the "Profile"
    Then the user is able to land to the "My Account"



Feature: Volkswagen Financial Services Home Page and checks the Vehicle exists.
  As a user i can able to open Volkswagen Financial Services Home Page and check for the entered vehicle is exist.

  Background:
    Given User is on the Volkswagen Financial Services Home Page on URL "https://covercheck.vwfsinsuranceportal.co.uk"
    Then I should see Volkswagen Financial Services displayed
    And I should see page tittle Dealer Portal

  @Test
  Scenario Outline: User should able to Enter the vehicle Number and and see if a vehicle is exist
    When I enter vehicle "<Registration Number>" in the input field
    And I click on Find Vehicle
    Then I should see the Vehicle detail

    Examples:
      |Registration Number|
      |OV12UYY            |
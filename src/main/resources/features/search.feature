@google
Feature: Google search

  Scenario: I can find my cheese
    Given I am on the google homepage
    When I search for "Cheese"
    Then I get my "Cheese - Google Search"

  Scenario: I can find my swag
    Given I am on the google homepage
    When I search for "Swag"
    Then I get my "Swag - Google Search"
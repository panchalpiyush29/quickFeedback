@google
Feature: Google search

  Scenario: I can find my cheese
    Given I am on the google homepage
    When I search for "Cheese"
    Then I get 10 "search results for Cheese"

  Scenario: I can find my swag
    Given I am on the google homepage
    When I search for "Swag"
    Then I get 10 " search results for Swag"
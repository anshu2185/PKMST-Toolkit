Feature: Hello World API

  Scenario: Get hi
    Given I query hi
    When I make the rest call
    Then response should contain:
      """
      Hi from Spring Cloud
      """
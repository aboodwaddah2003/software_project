Feature: Monitor users activity

  Scenario: the admin want to know the users login and logout records on the system
    Given the admin logs into the dashboard
  When  the admin go to  displays a user activity panel
 Then The panel shows key statistics such as the number of active users, number of login to the system


  Scenario: the admin want to show activity specific user
    Given the admin logs into the dashboard
    When  the admin go to  displays a user activity panel
    And chose the user he wants
    Then  the actions performed by the user will be displayed

  Scenario Outline: the admin want to show activity specific date
    Given the admin logs into the dashboard
    When  the admin go to  displays a user activity panel
    And chose the date "<date>" he wants
    Then  all actions that occurred on that specific date will be appear
    Examples:
    |date      |
    |15-09-2024|


  Scenario Outline: the admin want to show activity invalid specific date
    Given the admin logs into the dashboard
    When  the admin go to  displays a user activity panel
    And chose the invalid date "<date>"
    Then  alert show the user is invalid
    Examples:
      |date      |
      |30-09-2025 |
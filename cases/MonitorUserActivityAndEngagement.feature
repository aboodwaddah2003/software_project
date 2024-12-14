Feature: Monitor users activity

  Scenario: the admin want to know the users activity on the system
    Given the admin logs into the dashboard
  When  the admin go to  displays a user activity panel
    Then The panel shows key statistics such as the number of active users, number of login to the system, and overall engagement rates




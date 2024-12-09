Feature: Monitor user activity

  Scenario: the admin want to know the users activity on the system
    Given the admin logs into the dashboard
  When  the admin go to  displays a user activity panel
    Then The panel shows key statistics such as the number of active users, number of login to the system, and overall engagement rates

    Scenario: The admin wants to know the activity of a specific user
      Given the admin logs into the dashboard
      When  the admin go to  displays a user activity panel
      And  choose specific user from the list
      Then the system displays detailed user information

Scenario: the admin want to generating reports
  Given the admin logs into the dashboard
  When the admin go to generating reports panel
  And click on generate reports button
  Then a pdf report is generated including visual data such as active user trends and engagement metrics


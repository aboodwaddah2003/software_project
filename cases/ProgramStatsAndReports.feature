
Feature: View statistics on the most popular programs and Generate Reports on Revenue,
  Attendance,and Client Progress

Scenario: View statistics on the most popular programs by enrollment
Given the admin is logged into the dashboard
When the admin navigates to the Program Statistics section
Then the system displays a list of programs sorted by enrollment count


  Scenario: Admin generates a revenue report
    Given the admin is logged into the dashboard
    When the admin navigates to the Reports section
     And  selects Revenue Reports
    Then the system calculates the total revenue and display it

  Scenario: Admin generates an attendance report

    Given the admin is logged into the system
    And the admin navigates to the "Reports" section
    When the admin selects "Attendance Report"
    And specifies a program and date range
    Then the system retrieves attendance records for the selected program then displays attendance percentages and participant counts

  Scenario: Admin generates a client progress report

    Given the admin is logged into the system
    And the admin navigates to the "Reports" section
    When the admin selects "Client Progress Report"
    And specifies a program or a specific client
    Then the system retrieves data on client milestones and progress percentage then displays individual progress for each client enrolled in the program

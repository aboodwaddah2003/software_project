
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


  Scenario: Admin generates a attendance report
    Given the admin is logged into the dashboard
    When the admin navigates to the Reports section
    And  want to show all attendance percentage in each program
    Then the system view the attendance Reports that include the attendance percentage


  Scenario: Admin generates a attendance report
    Given the admin is logged into the dashboard
    When the admin navigates to the Reports section then enter the name of client
    And  selects attendance Reports
    Then the system view the attendance Reports

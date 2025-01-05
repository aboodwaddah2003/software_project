Feature: Progress Tracking
  As a gym user
  I want to track my personal fitness milestones
  So that I can monitor my progress and earn achievements

  Background:
    Given the user is logged into the system

  Scenario: User logs multiple fitness milestones
    Given the user is on the "Progress Tracking" page
    When the user logs the following milestones:
      | Weight | BMI  | Attendance        |
      | 70kg   | 22.5 | 3 days this week  |
      | 68kg   | 21.8 | 4 days this week  |
      |        | 22.5 | 3 days this week  |
      | 68kg   |       | 4 days this week  |
      | 68kg   |       |                   |
    Then the system saves all milestones successfully
    And displays a confirmation message "All milestones saved successfully!"

  Scenario: User earns badges for completing milestones
    Given the user has the following milestones:
      | Weight | BMI  | Attendance        |
      | 68kg   | 21.8 | 4 days this week  |
    When the user views their progress
    Then the system displays the following badges:
      | Badge Name           | Criteria Met            |
      | Consistent Attendee  | 4 days attendance       |
      | Healthy BMI Achiever | BMI is in healthy range |

  Scenario: User logs milestones with one field empty
    Given the user is on the "Progress Tracking" page
    When the user logs the following milestones:
      | Weight | BMI  | Attendance        |
      | 70kg   |      |                   |
    Then the system saves all milestones successfully
    And displays a confirmation message "All milestones saved successfully!"


  Scenario: User views progress over time
    Given the user has logged multiple milestones:
      | Date       | Weight | BMI  | Attendance        |
      | 01/01/2024 | 70kg   | 22.5 | 3 days this week  |
      | 01/02/2024 | 68kg   | 21.8 | 4 days this week  |
    When the user views their progress report
    Then the system displays a chart showing progress in weight and BMI

  Scenario: System sends a reminder to log milestones
    Given the user has not logged milestones for 7 days
    When the system checks the user's activity
    Then the system sends a reminder "Don't forget to log your progress!"

  Scenario: User updates a logged milestone
    Given the user has the following milestones:
      | Weight | BMI  | Attendance        |
      | 70kg   | 22.5 | 3 days this week  |
    When the user updates the milestone "Weight" to "68kg"
    Then the system saves the updated milestone successfully
    And displays a confirmation message "Milestone updated successfully!"

  Scenario: User deletes a logged milestone
    Given the user has the following milestones:
      | Weight | BMI  | Attendance        |
      | 70kg   | 22.5 | 3 days this week  |
    When the user deletes the milestone for "Attendance"
    Then the system removes the milestone successfully
    And displays a confirmation message "Milestone deleted successfully!"

Feature: Program Exploration and Enrollment

  # Scenario 1: Browsing programs by difficulty level
  Scenario: Client browses programs by difficulty level
    Given the client is on the program exploration page
    When the client filters programs by difficulty level
      | difficulty level |
      | Beginner         |
      | Intermediate     |
      | Advanced         |
    Then the system displays all programs with each difficulty level

  # Scenario 2: Browsing programs by focus area
  Scenario: Client browses programs by focus area
    Given the client is on the program exploration page
    When the client filters programs by focus area
      | focus area      |
      | Weight loss     |
      | Muscle building |
      | Flexibility     |
    Then the system displays all programs in each focus area

  # Scenario 3: Enrolling in a program
  Scenario: Client enrolls in a program
    Given the client is on the program exploration page
    When the client selects a program
      | program name             |
      | Muscle Gain Program      |
      | Weight Loss Program      |
      | Flexibility Program      |
    Then the system enrolls the client in the selected program
    And the system shows the confirmation message "Successfully enrolled in {program name}"

  # Scenario 4: Viewing the schedule of an enrolled program
  Scenario: Client views the schedule of an enrolled program
    Given the client is enrolled in a program
      | program name        |
      | Weight Loss Program |
      | Muscle Gain Program |
      | Flexibility Program |
    When the client requests to view the schedule of the program
    Then the system displays the schedule for the selected program

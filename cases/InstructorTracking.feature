Feature: Instructor Tracking the progress of clients

  Scenario: The instructor add milestones for client

    Given the instructor clicks on the clientsTracking
    When the instructor select a specific client
    And  add the required data for the client
    Then the system will add the data for specific client



  Scenario: The instructor want to progress client

    Given the instructor clicks on the clientsTracking
    When the instructor search on specific client
    And  press show activity button
    Then the system will  the data for specific client


  Scenario: Send Motivational Reminders

    Given the instructor Send motivational reminders
    When the instructor select a client and compose a motivational message
    And the instructor clicks on the "sendMotivation" button10
    Then An messasge appear to clients
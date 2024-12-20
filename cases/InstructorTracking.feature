Feature: Instructor Tracking the progress of clients

  Scenario: Monitor Client Progress

    Given the instructor in the programs management page4
    And the instructor clicks on the "clientsTracking" button7
    When the instructor select a specific client
    And the instructor clicks on the "progressMetrics" button8
    Then the system displays progress metrics.

  Scenario: Send Motivational Reminders

    Given the instructor in the programs management page4
    And the instructor clicks on the "clientsTracking" button9
    When the instructor select a client and compose a motivational message
    And the instructor clicks on the "sendMotivation" button10
    Then An messasge appear to clients
    And the clients receive the reminders via their profils
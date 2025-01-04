Feature: Notifications and Updates

  Scenario: Notify Clients about Program Changes

    Given the instructor in the programs management paage1
    And the instructor make changes to a program
    When the instructor confirm the updates
    Then the system automatically notifies all enrolled clients about the changes via their preferred notification method,and includes the updated details in the notification.



  Scenario: Announce New Programs

    Given the instructor has created a new program
    When the instructor clicks on the "AnnounceProgram" button4
    Then the system sends a notification to all clients about the new program

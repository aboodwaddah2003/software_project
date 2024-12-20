Feature: Notifications and Updates

  Scenario: Notify Clients about Program Changes

    Given the instructor in the programs management paage1
    And the instructor make changes to a program
    When the instructor confirm the updates
    Then the system automatically notifies all enrolled clients about the changes via their preferred notification method
    And includes the updated details in the notification.


  Scenario: Announce New Programs

    Given the instructor has created a new program
    When the instructor clicks on the "AnnounceProgram" button4
    Then the system sends a notification to all clients about the new program
    And includes program details such as title, duration, difficulty level, and enrollment instructions.

  Scenario: Notify Clients about Special Offers

    Given the instructor wants to promote a special offer
    When the instructor create a new announcement by clicking on the "Promotions" button
    And specify the offer details and applicable clients
    Then the system sends the announcement to the selected clients
    And tracks client engagement, such as views or enrollments resulting from the offer.

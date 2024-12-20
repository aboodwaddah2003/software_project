Feature: Instructor interacting with the clients

  Scenario: Send a Message to Clients
    Given the instructor in the programs management page111
    And the instructor clicks on the "clientsTracking" botton
    When the instructor select one or more enrolled clients and compose a message
    And the instructor clicks on the "send" bottonn
    Then the system sends the message to the selected clients
    And the clients receive the message in their accounts.

  Scenario:the instructor Cancel sending
    Given the instructor is in the process of sending a new message
    When the instructor click the "Cancel" button1
    Then the system cancel the sending operation

  Scenario: the instructor provides individual feedback
    Given the instructor is in the client profile
    When the instructor compose a message and clicks on "send feedback" button2
    Then the system sends the feedback to the client

  Scenario: the instructor provides individual report
    Given the instructor is in the client profile
    When the instructor compose a message and clicks on "send report" button3
    Then the system sends the report to the client
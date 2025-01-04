Feature: Instructor interacting with the clients

  Scenario: Send a Message to Clients
    Given the instructor select one enrolled client and compose a message
    When the instructor clicks on the "send" bottonn
    Then a message arrive to the buyers

  Scenario: Send a Message to Clients without full details
    Given the instructor select one enrolled client and did not write the message
    When the instructor clicks on the "send" bottonnn
    Then a message did not arrive to the buyers

  Scenario: the instructor provides individual feedback
    Given the instructor want to provide a feedback
    When the instructor write a message and clicks on "send feedback" button2
    Then the system sends the feedback to the client

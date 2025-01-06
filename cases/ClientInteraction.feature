Feature: Instructor interacting with the clients

  Scenario: Send a Message to Clients
    Given the instructor select one enrolled client and compose a message
    When the instructor clicks on the "send" bottonn
    Then a message arrive to the buyers

  Scenario: Send a Message to Clients without full details
    Given the instructor select one enrolled client and did not write the message
    When the instructor clicks on the "send" bottonnn
    Then a message did not arrive to the buyers


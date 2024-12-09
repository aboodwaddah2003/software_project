Feature: Approve new instructor registrations

  Scenario: The admin approves a new instructor's registration request
    Given the admin is on the instructor registration requests page
    When  the admin selects a pending instructor registration request from the list
    And   clicks the approve button for the selected request
    Then  the system updates the instructor's status to Approved and adds him

  Scenario:  The instructor’s email is already registered in the system
    Given the admin is on the instructor registration requests page
    When  the admin selects a pending instructor registration request from the list
    And   clicks the approve button1 for the selected request
    Then  alert show this username is already registered approval not possible

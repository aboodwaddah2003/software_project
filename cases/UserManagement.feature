Feature: Admin add or update or  deactivate accounts for instructors or clients.

  Scenario: the admin want to add new Clients account
    Given the admin in management user page
    When   the admin fills in the  valid client's information in the system
    And  clicks create account
    Then  the registered is successfully

  Scenario: the admin want to add new instructors account
    Given the admin in management user page
    When   the admin fills in the  valid instructors information in the system
    And  clicks create account
    Then  the registered is successfully

    Scenario: the admin add new account with invalid input
      Given the admin in management user page
      When   the admin fills in the  invalid instructors or client information in the system
      And  clicks create account button2
      Then  the registered is unsuccessfully and alert show there is a invalid input


      Scenario: the admin want to update valid  new username for client or instructor account
        Given the admin in management user page
        When the admin enter new valid username
        And press update information button
        Then alert show that the username updated successfully

  Scenario: the admin want to update  new username for client or instructor account that already exist in the system
    Given the admin in management user page
    When the admin enter the new username that already exist in the system
    And press update information button
    Then alert show that The username is already in use

  Scenario: the admin want to update one or more valid data for client or instructor account
    Given the admin in management user page
    When the admin enter the new valid email or valid role or valid subscription Plans or valid password
    And press update information button
    Then alert show that The update operation is success

    Scenario: the admin want to update  new email that already in the system
      Given the admin in management user page
      When the admin enter the new  email that already in system
      And press update information button1
      Then alert show that the email is already in system

  Scenario: the admin want to deactivate client or instructor account
    Given the admin in management user page
    When the admin chooses the account he wants to deactivate
    And press deactivate account
    Then alert show that  the account become deactivate and user cant enter system

  Scenario: the admin want to deactivate client or instructor account that already deactivated
    Given the admin in management user page
    When the admin chooses the account he wants to deactivate
    And press deactivate account button
    Then An alert appears notifying the admin that the account is already deactivated
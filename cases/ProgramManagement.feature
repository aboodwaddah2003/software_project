Feature: Instructor create, update or delete fitness programs.

  Scenario: the instructor successfully create a new program
    Given the instructor in the programs management page3
    When the instructor select "CreateNewProgram"
    And the instructor provide the required details
    And the instructor clicks "Save" button5
    Then the system saves the new program and displays a confirmation message,And the program becomes available for clients.

  Scenario: the instructor try to save without providing inputs
    Given the instructor in programs management page31
    When the instructor select "CreateNewProgram"
    And  the instructor try to save the program without providing inputs
    And the instructor clicks "Save" button
    Then  the creation is unsuccessfully and alert show you should fill all details

  Scenario: the instructor Cancel Creation
    Given the instructor is in the process of creating a new program
    When the instructor click the "Cancel" button5
    Then the system discards the unsaved program details



  Scenario: the instructor successfully Update a Program

    Given the instructor in the programs management page33
    When the instructor select an existing program and click on the "update" button
    And the instructor update the program details
    Then the system saves the updated program and displays a confirmation message
    And the updated program details are immediately reflected for clients.

  Scenario: Validation Errors During Update

    Given the instructor is editing a program
    When the instructor try to save the changes without providing mandatory fields
    Then the system shows validation error messages indicating the missing fields.

  Scenario: Cancel Updates

    Given the instructor is in the process of editing a program
    When the instructor click the "Cancel" button
    Then the system discards the unsaved changes and retains the original program details.



  Scenario: the instructor successfully Delete a Program

    Given the instructor in the programs management page333
    When the instructor select an existing program and click on the "delete" button
    Then the system permanently deletes the program
    And the program is no longer visible for clients.

  Scenario: the instructor Cancelled Deletion

    Given the instructor is in the process of deleting a program
    When the instructor clicks on the "Cancel" buttonn
    Then the system aborts the deletion process
    And the program remains unchanged and visible for clients.

  Scenario: Restriction on Deletion

    Given the instructor tries to delete a program assigned to active gym members
    When the instructor click the "delete" button6
    Then the system shows a notification that the program cannot be deleted until it is unassigned from all active members
    And the deletion process is halted.

  Scenario: Confirmation Prompt appears

    Given the instructor clicks on the "delete" buttonnn
    When the system displays a confirmation prompt with details about the program to be deleted
    Then the instructor must confirm the deletion by clicking "Confirm" button ,Or cancel the action by clicking "Cancel" button.
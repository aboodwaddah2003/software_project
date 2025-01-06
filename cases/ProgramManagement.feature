Feature: Instructor create, update or delete fitness programs.

  Scenario: the instructor successfully create a new program
    Given the instructor in the programs management page3
    When the instructor select CreateNewProgram
    Then the system saves the new program and displays a confirmation message,And the program becomes available for clients.

  Scenario: the instructor try to save without providing inputs
    Given the instructor in programs management page3
    When the instructor select CreateNewProgram
    And  the instructor try to save the program without providing inputs
    Then  the creation is unsuccessfully and alert show you should fill all details




  Scenario: the instructor successfully Update a Program

    Given the instructor in the programs management page33
    When the instructor select an existing program and click on the "update" button
    And the instructor update the program details
    Then the system saves the updated program and displays a confirmation message

  Scenario: Validation Errors During Update

    Given the instructor is editing a program
    When the instructor try to save the changes without providing mandatory fields
    Then the system shows validation error messages indicating the missing fields.



  Scenario: the instructor successfully Delete a Program

    Given the instructor in the programs management page333
    When the instructor select an existing program and click on the delete button
    Then the system permanently deletes the program



  Scenario: Restriction on Deletion

    Given the instructor tries to delete a program not complete
    When the instructor click the "delete" button6
    Then the system shows a notification that the program cannot be deleted until it is unassigned from all active members



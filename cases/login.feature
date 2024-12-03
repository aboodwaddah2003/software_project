
Feature: User tries to log in to the system

  Scenario Outline: The user enters a valid username and password
    Given the user is on the login page
    When the user enters a valid username "<username>" and a valid password "<password>"
    And presses the login button
    Then the user is successfully logged into the system

    Examples:
      | username | password |
      | osama    | 1234  |
      | abood   | 1234  |


    Scenario Outline: The user enters invalid username
      Given the user is on the login page
      When  the user enters  invalid username "<username1>"
      And   press the login button
      Then  the login attempt fails with an error username message
      Examples:
        | username1 |
        | osama1   |

  Scenario: User login with invalid password
    Given the user is on the login page
    When the user enters an invalid password "<password>"
    And clicks the login button3
    Then the login attempt fails with an error pass message


  Scenario: User login with missing username or password
    Given the user is on the login page
    When the user leaves the username field empty and enters a password "password1"or empty pass with valid username"osama"
    And clicks the login button4
    Then the login attempt fails with an error message for missing username

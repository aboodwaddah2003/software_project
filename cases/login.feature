
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


    Scenario Outline: The user enters invalid password
      Given when the user in the login page
      When  the user enters  invalid password {string}
      And   press the login button
      Then  the login attempt fails with an error pass message
      Examples:
        | username | password |
        | osama    | 1010  |

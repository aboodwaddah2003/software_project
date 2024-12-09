Feature: user tires to signup to the system

  Scenario Outline: user enters the all fields correctly and signup in system
    Given the user in signup page
    When the user enter a valid username '<userName>' and '<password>' and '<email>'  and '<role>' and'<subPlan>'
    Then the user successful make account in system and the alert show success signUp
    Examples:
      | userName    | password       | email               | role    | subPlan|
      | mohammad    | ab12345678     | mohammad@gmail.com  | Client  | Basic  |


Scenario Outline: user try to signup with username is exist already
  Given the user in signup page
  When  the user enter the username "<username>" that is exist already
  Then  alert show that the username is exist in the system

  Examples:
  |username|
  |osama   |


  Scenario Outline: User SignUp with one of the input empty
    Given the user in signup page
    When the user enter an empty username '<userName>' or  '<password>'   or '<email>' or '<role>'
    Then the alert show that there is Field empty

    Examples:
      | userName | password        | email            | role    |
      | osama    |                 | os@gmail.com     | admin   |
      |          | ahmed123        | ahmed@gmail.com  | Client  |
      | najwa    | naj1234wa       |                  | admin   |


    Scenario: user signup with invalid email
      Given  the user in signup page
      When the user enter invalid email "osama@"
      Then alert show that the email error format


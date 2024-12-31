Feature: Feedback and Reviews
  As a client, I want to rate and review completed programs and submit improvement suggestions to instructors, so I can provide feedback on my experiences.

  # Scenario 1: Client submits feedback for a completed program
  Scenario Outline: Client submits feedback for a completed program
    Given the client has completed a program "<programName>"
    When the client rates the program <rating> and writes a review "<review>" with improvement suggestions "<improvementSuggestions>"
    Then the system submits the feedback for the program "<programName>"

    Examples:
      | programName        | rating | review               | improvementSuggestions              |
      | Muscle Gain Program | 4      | Great program!        | Include more advanced techniques.    |
      | Weight Loss Program | 5      | Excellent program!    | More variety in exercises.          |
      | Flexibility Program | 3      | Good program.          | Should be more engaging.            |
      | Yoga Program        | 2      | Not challenging enough | More difficult poses are needed.    |

  # Scenario 2: Client views feedback for a specific program
  Scenario: Client views feedback for a specific program
    Given the client has completed a program "Muscle Gain Program"
    And the client has submitted feedback for the program
    When the client requests to view the feedback for "Muscle Gain Program"
    Then the system displays the feedback for "Muscle Gain Program"

  # Scenario 3: Client submits feedback without improvement suggestions
  Scenario Outline: Client submits feedback without improvement suggestions
    Given the client has completed a program "<programName>"
    When the client rates the program <rating> and writes a review "<review>" without improvement suggestions
    Then the system submits the feedback for the program "<programName>"

    Examples:
      | programName        | rating | review               |
      | Weight Loss Program | 5      | Excellent program!    |
      | Flexibility Program | 3      | Needs improvement.    |
      | Yoga Program        | 4      | Enjoyed the sessions. |
      | Muscle Gain Program | 2      | Not worth the effort. |

  # Scenario 4: Client submits feedback with empty review or missing rating
  Scenario Outline: Client submits incomplete feedback
    Given the client has completed a program "<programName>"

    Then the system should display an error message for "<programName>"

    Examples:
      | programName        | rating | review               |
      | Weight Loss Program | 0      |                       |
      | Flexibility Program | -1     | Too short.            |
      | Yoga Program        | 5      |                       |
      | Muscle Gain Program | 3      |                       |

    # Scenario 5: Client submits feedback for multiple programs
  Scenario: Client submits feedback for multiple programs

    Given the client submits feedback for each program
      | Program Name        | Rating | Review              | Improvement Suggestions   |
      | Muscle Gain Program | 4      | Great program!      | Include more advanced techniques |
      | Weight Loss Program | 5      | Excellent program!  | More variety in exercises  |


    Then the system submits the feedback for all the programs successfully
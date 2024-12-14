Feature: Account Management

  Scenario: Client creates profiles with personal details
    Given the client is on the profile creation page
    When the client enters valid personal details
      | name   | age | goals        |
      | adham   | 25  | Weight Loss  |
      | ahmad  | 30  | Muscle Gain  |
      | mohammad   | 28  | Weight Loss  |
    Then the system successfully saves the client's profile
    And shows a confirmation message "Profile created successfully"

  Scenario: Client updates dietary preferences for existing profiles
    Given the client has existing profiles
    When the client updates dietary preferences
      | preferences   |
      | Vegetarian    |
      | Vegan         |
      | Gluten-Free   |
    Then the system saves the updates
    And displays a message "Preferences updated successfully"

  Scenario: Client tries to create a profile with missing details
    Given the client is on the profile creation page
    When the client leaves the age field empty
      | name   | goals        |
      | adham   | Weight Loss  |
      | ahmad  | Muscle Gain  |
    Then the system shows an error message "All fields are required"

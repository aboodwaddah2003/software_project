Feature:Approve or reject content shared by instructors, including wellness articles, tips, and recipes and Handle User Feedback

  Scenario Outline: Admin approves a wellness article shared by an instructor


   Given the admin navigates to the Pending Submissions section
    When the admin selects a wellness submitted by an instructor
    And select the "<title>" form the wellness that want to approved
    Then the system updates the article status to Approved

    Examples:
    |title|
    |10 Healthy Recipes|




  Scenario Outline: Admin rejects a wellness tip shared by an instructor

    Given the admin navigates to the Pending Submissions section
    When the admin selects a wellness submitted by an instructor
    And select the "<title>" form the wellness that want to rejected
    Then the system updates the article status to rejected
    Examples:
      |title|
      | Fitness Tips |



  Scenario Outline: Admin approves a health and wellness tip
    Given the admin navigates to the Pending Submissions section
    When the admin selects a wellness or tips submitted by user
    And select the "<title>" form the wellness or tips that want to approved
    Then the system updates the article status to Approved

    Examples:
      |title|
      |Strength Training Basics|




  Scenario: Admin addresses a user complaint

    Given the admin is logged into the system
    And the admin navigates to the "User Feedback and Complaints" section
    When the admin selects a user complaint
    And reviews the details of the complaint
    Then the admin can respond with a solution or clarification then updates the status of the complaint to "Resolved"

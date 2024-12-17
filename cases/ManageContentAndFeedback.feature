@tag2
Feature:  Approve or reject content shared by instructors, including wellness articles, tips, and recipes and Handle User Feedback

  Scenario Outline: Admin approves a wellness article shared by an instructor


   Given the admin navigates to the Pending Submissions section
    When the admin selects a wellness submitted by an instructor
    And select the "<title>" form the wellness that want to approved
    Then the system updates the article status to Approved

    Examples:
    |title|

    |   10 Healthy Recipes   |




  Scenario Outline: Admin rejects a wellness tip shared by an instructor

    Given the admin navigates to the Pending Submissions section
    When the admin selects a wellness submitted by an instructor
    And select the "<title>" form the wellness that want to rejects
    Then the system updates the article status to Approved

    Examples:

      |title|
      | Fitness Tips |


  Scenario: Admin approves a health and wellness tip
    Given the admin is logged into the system
    And the admin navigates to the "Pending Submissions" section
    When the admin selects a tip submitted on health and wellness
    And clicks the "Approve" button
    Then the system updates the tip status to "Approved"
    And the tip is published and visible to users


  Scenario: Admin rejects a health and wellness article

    Given the admin is logged into the system
    And the admin navigates to the "Pending Submissions" section
    When the admin selects an article submitted on health and wellness
    And clicks the "Reject" button
    And provides feedback on why it was rejected
    Then the system updates the article status to "Rejected"
    And the instructor is notified of the feedback provided


  Scenario: Admin addresses a user complaint

    Given the admin is logged into the system
    And the admin navigates to the "User Feedback and Complaints" section
    When the admin selects a user complaint
    And reviews the details of the complaint
    Then the admin can respond with a solution or clarification then updates the status of the complaint to "Resolved"


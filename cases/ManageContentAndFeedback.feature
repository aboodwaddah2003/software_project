Feature:  Approve or reject content shared by instructors, including wellness articles, tips, and recipes and Handle User Feedback

  Scenario: Admin approves a wellness article shared by an instructor

    Given the admin is logged into the system
    And the admin navigates to the "Pending Submissions" section
    When the admin selects a wellness article submitted by an instructor
    And clicks the "Approve" button
    Then the system updates the article status to "Approved"
    And the article is published and visible to users

  Scenario: Admin rejects a wellness tip shared by an instructor

    Given the admin is logged into the system
    And the admin navigates to the "Pending Submissions" section
    When the admin selects a wellness tip submitted by an instructor
    And clicks the "Reject" button
    And provides a reason for rejection
    Then the system updates the tip status to "Rejected"
    And sends a notification to the instructor with the rejection reason

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


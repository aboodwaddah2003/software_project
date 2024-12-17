
Feature: TrackActive And Completed Programs



Scenario: Admin views active programs
Given the admin is logged into the system
When the admin navigates to the Programs section
And the admin selects Active Programs
Then the system displays a list of all active programs with details



Scenario: Admin views completed programs
Given the admin is logged into the system
When the admin navigates to the Programs section
And the admin selects Completed Programs
Then the system displays a list of all completed programs

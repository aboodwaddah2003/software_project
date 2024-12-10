
Feature: TrackActive And Completed Programs
Scenario: Admin views active programs

Given the admin is logged into the system
And the admin navigates to the "Programs" section
When the admin selects "Active Programs"
Then the system displays a list of all active programs
And shows details such as program name, start date, and current enrollment


Scenario: Admin views completed programs

Given the admin is logged into the system
And the admin navigates to the "Programs" section
When the admin selects "Completed Programs"
Then the system displays a list of all completed programs
And shows details such as program name, end date, and total enrollment
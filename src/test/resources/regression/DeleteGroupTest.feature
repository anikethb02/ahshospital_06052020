@DeleteGrpTest
Feature: Delete from assign group tests.

Scenario Outline: Verify super admin can delete from Assign Group Test list.
Given Super admin logged in
And Navigated to Masters page
And Navigated to Assign Group Test
When search name or number "<phrase>"  is entered
Then results for name or number "<phrase>" are shown
When delete button clicked for the result
When search name or number "<phrase>"  is entered
Then user should NOT see the corresponding "<phrase>" result

Examples:

| phrase       |
| TB4 UREN     |
| TB3 Crystals |
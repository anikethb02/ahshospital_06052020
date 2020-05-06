@Search
Feature: Search from assign group test

Scenario Outline: Verify super admin can search from Assign Group Test list.
Given Super admin logged in
And Navigated to Masters page
And Navigated to Assign Group Test
When search name or number "<phrase>"  is entered
Then results for name or number "<phrase>" are shown

Examples:

| phrase |
| Urea   |
| 999    |
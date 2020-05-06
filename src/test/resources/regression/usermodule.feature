@1
Feature: User module

  Scenario Outline: 3 User can be created

    Given admin logged into the portals
    When he go to user module
    And created a new user "<Role>"
    Then the user should be created successfully


    Examples:
      | Role       |
      | SuperAdmin |

    Examples:
      | Role         |
      | CallCenter   |
      | LabTechnican |
      | Admin        |

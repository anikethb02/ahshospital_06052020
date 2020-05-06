@AssignGroupTest
Feature:  Assign Group Test

  Scenario Outline: Verify super admin can create Assign Group Test.
    Given Super admin logged in
    And Navigated to Masters page
    And Navigated to Assign Group Test
    When opens the Add Assign Group Test
    And set Group test as "<Group test>" Main test as "<Main test>" Sub test as "<Sub test>"
    And Submits the data to create Assign Group Test
    Then should be navigating to list of Assign Group Test

    Examples:
      | Group test | Main test | Sub test        |
      | Haemogram  | URINE     | RBC Count       |
      | Haemogram  | URINE     | Total WBC Count |

  @GroupTestFailure
  Scenario Outline: Verify super admin cannot create Assign Group Test without valid information.

    Given Super admin logged in
    And Navigated to Masters page
    And Navigated to Assign Group Test
    When opens the Add Assign Group Test
    And set Group test as "<Group test>" Main test as "<Main test>" Sub test as "<Sub test>"
    And Submits the data to create Assign Group Test
#    Then the error message is displayed
    @Fail
    Examples:
      | Group test     | Main test          | Sub test         |
      | -Select Test *-|-Select Category *- |-Select SubTest *-|
      | Haemogram      | URINE              |-Select SubTest *-|
      | Haemogram      | URINE              |-Select SubTest *-|








@Reports
Feature: Reports
Scenario Outline: verify super admin can range the Dates.
Given      Super admin logged in
And        Navigated to the reports page.
#When       search range of the dates from date1 "<fromdate>" to date2 "<todate>"
When when i pass start date "<fromdate>" and end date "<todate>"
Then       submit the selected date range

Examples:

| fromdate       | todate        |
| 01/March/2020  | 16/April/2020 |
#| 07/Dec/2019  | 28/Dec/2019 |

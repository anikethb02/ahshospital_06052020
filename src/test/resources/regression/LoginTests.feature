Feature: Login Page features

@aniketh
  Scenario Outline: 1 Success logins

    Given user is in login page
    When he login with username "<username>" and password "<password>"
    Then the login should be successful

    Examples:

      | username    | password   |
#      | 1234567891  | ahs@123     |
      | 07442382353 | Superadmin |
#      | 07442382354 | 07442382354 |


  Scenario Outline: 2 Failure logins

    Given user is in login page
    When he login with username "<username>" and password "<password>"
    Then the error message is shown "<Message>"
  @sriram
    Examples:

      | username   | password   | Message                                         |
      | 1234567891 | ahs@123111 | Oops!Sorry invalid credentials please try again |

  @sriram
    Examples:
      | username    | password     | Message                                         |
      | 07442382353 | Superadmin11 | Oops!Sorry invalid credentials please try again |
      | 07442382354 | 07442382354  | Oops!Sorry invalid credentials please try again |
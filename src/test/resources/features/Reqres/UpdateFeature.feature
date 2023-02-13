Feature: Update user

  @Latihan1
  Scenario Outline: Put update user with valid json
    Given Put update user with valid json with id 2
    When Send request put update user
    Then Should return status code 200
    And Response body name should be "<name>" and job "<job>"
    And Validate json schema update user
    Examples:
      | name          | job         |
      | Dede Suryawan | QA Engineer |

  @Tugas @NegatifCase
  Scenario: Put update user with invalid json
    Given Put update user with invalid json with id 2
    When Send request put update user
    Then Should return status code 400
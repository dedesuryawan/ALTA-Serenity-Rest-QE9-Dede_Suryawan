Feature: Create new user
  @Latihan1
  Scenario Outline: Post create new user with valid json file
    Given Create new user with valid json
    When Send request post create user
    Then Status code should be 201 Created
    And Respone body name should be "<name>" and job is "<job>"
    And Validate json schema create user

    Examples:
      | name          | job         |
      | Dede Suryawan | QA Engineer |


  @Tugas @NegatifCases
  Scenario: Post create new user with invalid json
    Given Post create user with invalid json
    When Send request post create user
    Then Should return status code 400
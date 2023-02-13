Feature: List User Reqres API Automation Testing QE-9

  Scenario Outline: Get list users with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send users request get list users
    Then Status code should be 200 ok
    And Respone body page should be <page>
    And Validate get list user json schema

    Examples:
      | page |
      | 1    |
      | 2    |

  @Latihan1
  Scenario: Post create new user with valid json file
      Given Create new user with valid json
      When Send request post create user
      Then Status code should be 201 Created
      And Respone body name should be "Dede Suryawan" and job is "QA Engineer"


  @Tugas @NegatifCases
  Scenario Outline: Get list user with invalid parameter page
    Given Get list user with invalid page "<page>"
    When Send request get list user
    Then Should return status code 404
    Examples:
      | page   |
      | $$%$$$ |
      | **###  |
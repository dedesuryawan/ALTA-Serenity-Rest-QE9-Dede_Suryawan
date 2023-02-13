Feature: Post Method Reqres API Automation Testing QE-9 "Register user"

  @Tugas @PositifCase
  Scenario: Register user with valid json
    Given Register user with valid json
    When Send request register user
    Then Should return status code 200
    And Validate json schema success register user


  @Tugas @NegatifCase
  Scenario: Register user with invalid json
    Given Register user with invalid json
    When Send request register user
    Then Should return status code 400
    And Response body error should be "Missing password"
    And Validate json schema failed register user
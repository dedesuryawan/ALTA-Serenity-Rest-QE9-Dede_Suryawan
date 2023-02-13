Feature: Login user

  @Tugas @PositifCases
  Scenario: Login user with registered users and match input email and password
    Given Login user with valid json
    When Send request login user
    Then Should return status code 200
    And Validate json schema success login user


  @Tugas @NegatifCases
  Scenario: Login user with registered users and input blank in password
    Given Login user with invalid json
    When Send request login user
    Then Should return status code 400
    And Response body error should be "Missing password"
    And Validate json schema failed login user
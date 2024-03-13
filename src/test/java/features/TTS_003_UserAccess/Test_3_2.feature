@e2e
@TTS_B
@ignore
Feature: User Login & Registration

  Scenario: Invalid email
    Given navigate to page "login"
    When fill username field with "INVALID_admin"
    When fill password field with "12345"
    When click login button
    Then check presence of alert box containing message "Username or Password is not correct."

  Scenario: Invalid password
    Given navigate to page "login"
    When fill username field with "admin"
    When fill password field with "INVALID_12345"
    When click login button
    Then check presence of alert box containing message "Username or Password is not correct."

  Scenario: Invalid email and password
    Given navigate to page "login"
    When fill username field with "INVALID_admin"
    When fill password field with "INVALID_12345"
    When click login button
    Then check presence of alert box containing message "Username or Password is not correct."
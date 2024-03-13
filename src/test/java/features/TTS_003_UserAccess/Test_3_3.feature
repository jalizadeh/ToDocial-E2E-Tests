@e2e
@TTS_B
@ignore

#This test can be skipped for now, as currently there is no mechanism on FE to handle empty field
Feature: User Login & Registration

  Scenario: Missing email
    Given navigate to page "login"
    When fill username field with ""
    When fill password field with "12345"
    When click login button
    Then check presence of alert box containing message "Missing field data"

  Scenario: Missing password
    Given navigate to page "login"
    When fill username field with "admin"
    When fill password field with ""
    When click login button
    Then check presence of alert box containing message "Missing field data"

  Scenario: Missing email and password
    Given navigate to page "login"
    When fill username field with ""
    When fill password field with ""
    When click login button
    Then check presence of alert box containing message "Missing field data"
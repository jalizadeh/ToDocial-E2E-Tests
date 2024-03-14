@e2e
@TTS_003

# gathering all scenarios in one single feature file is to provide better view in Jenkins Cucumber report
Feature: User Login

  Scenario: Valid username & email
    Given navigate to page "login"
    When write "admin" into LoginPage.usernameInput
    When write "12345" into LoginPage.passwordInput
    When click LoginPage.loginButton

    # redirected to Home page
    Then check if has full access to top menu items

  Scenario: Invalid email
    Given navigate to page "login"
    When write "INVALID_admin" into LoginPage.usernameInput
    When write "12345" into LoginPage.passwordInput
    When click LoginPage.loginButton
    Then LoginPage.alertBox has text "Username or Password is not correct."

  Scenario: Invalid password
    Given navigate to page "login"
    When write "admin" into LoginPage.usernameInput
    When write "INVALID_12345" into LoginPage.passwordInput
    When click LoginPage.loginButton
    Then LoginPage.alertBox has text "Username or Password is not correct."

  Scenario: Invalid email and password
    Given navigate to page "login"
    When write "INVALID_admin" into LoginPage.usernameInput
    When write "INVALID_12345" into LoginPage.passwordInput
    When click LoginPage.loginButton
    Then LoginPage.alertBox has text "Username or Password is not correct."

#  Scenario: Missing email
#    Given navigate to page "login"
#    When fill username field with ""
#    When fill password field with "12345"
#    When click login button
#    Then check presence of alert box containing message "Missing field data"
#
#  Scenario: Missing password
#    Given navigate to page "login"
#    When fill username field with "admin"
#    When fill password field with ""
#    When click login button
#    Then check presence of alert box containing message "Missing field data"
#
#  Scenario: Missing email and password
#    Given navigate to page "login"
#    When fill username field with ""
#    When fill password field with ""
#    When click login button
#    Then check presence of alert box containing message "Missing field data"
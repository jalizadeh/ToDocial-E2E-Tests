@e2e
@TTS_003

Feature: User Logout

  Scenario: Logged in user can successfully log out
    Given navigate to page "login"
    When write "admin" into LoginPage.usernameInput
    When write "12345" into LoginPage.passwordInput
    When click LoginPage.loginButton

    # redirected to Home page
    Then user logs out

    Then check top and bottom menu for anonymous user
    Then LoginPage.alertBox has text "You logged out successfully."

  Scenario: Logged-out user tries to logout
    Given navigate to page "logout"
    Then check top and bottom menu for anonymous user
    Then login fields are visible
    Then LoginPage.alertBox should not be visible
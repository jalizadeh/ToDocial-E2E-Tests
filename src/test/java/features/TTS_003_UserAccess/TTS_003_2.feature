@e2e
@TTS_003

Feature: User Logout

  Scenario: Logged in user can successfully log out
    Given navigate to page "login"
    When fill username field with "admin"
    When fill password field with "12345"
    When click login button

    # redirected to Home page
    Then user logs out

    Then check top and bottom menu for anonymous user
    Then check presence of alert box containing message "You logged out successfully."

  Scenario: Logged-out user tries to logout
    Given navigate to page "logout"
    Then check top and bottom menu for anonymous user
    Then login fields are visible
    Then alert box should not be visible
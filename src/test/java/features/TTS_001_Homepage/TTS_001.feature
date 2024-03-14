@e2e
@TTS_001

Feature: Homepage

  Scenario: Verify elements presence for anonymous user
    Given navigate to page ""
    Then check top and bottom menu for anonymous user
    #Then check contents in the middle

  Scenario: Verify elements presence for logged in user
    Given navigate to page "login"
    When write "admin" into LoginPage.usernameInput
    When write "12345" into LoginPage.passwordInput
    When click LoginPage.loginButton

    # redirected to Home page
    Then check if has full access to top menu items
    #Then check contents in the middle
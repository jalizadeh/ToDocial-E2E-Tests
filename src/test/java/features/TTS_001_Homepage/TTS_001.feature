@e2e
@TTS_001
Feature: Homepage

  Scenario: Verify elements presence for anonymous user
    Given navigate to page ""
    Then check top and bottom menu for anonymous user
    #Then check contents in the middle

  Scenario: Verify elements presence for logged in user
    Given navigate to page "login"
    When fill username field with "admin"
    When fill password field with "12345"
    When click login button

    # redirected to Home page
    Then check if has full access to top menu items
    #Then check contents in the middle
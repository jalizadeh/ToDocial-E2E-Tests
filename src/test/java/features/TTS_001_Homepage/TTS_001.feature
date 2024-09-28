@e2e
@TTS_001

Feature: Homepage

  Scenario Outline: Verify elements presence for anonymous user
    Given navigate to homepage
    Then check top and bottom menu for anonymous user

    # checking contents in the middle
    Then HomePage.columnCommunity should be visible
    Then community user <fullname> with id <username> is in the list
    Then HomePage.columnRecentActivities should be visible
    Then HomePage.columnRecentActivities_Items size is "more" than 2

    Examples:
      | fullname                    | username      |
      | Javad Alizadeh              | admin         |
      | Alex Fergosen [EDITOR]      | mr.editor     |
      | Micheal J. Jackson [USER]   | mjackson.user |

  Scenario Outline: Verify elements presence for logged in user
    Given navigate to page "login"
    When write "admin" into LoginPage.usernameInput
    When write "12345" into LoginPage.passwordInput
    When click LoginPage.loginButton

    # redirected to Home page
    Then user has "admin" access to top menu items

    # checking contents in the middle
    Then HomePage.columnCommunity should be visible
    Then community user <fullname> with id <username> is in the list
    Then HomePage.columnRecentActivities_Items size is "more" than 2

    Examples:
      | fullname                    | username      |
      | Javad Alizadeh              | admin         |
      | Alex Fergosen [EDITOR]      | mr.editor     |
      | Micheal J. Jackson [USER]   | mjackson.user |
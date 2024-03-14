@e2e
@TTS_003

Feature: Forgot Password

  Scenario: Forgot password process for valid email
    Given navigate to page "login"
    When click LoginPage.forgotPassLink

    # redirected to FP page
    Then write "alf@yahoo.com" into LoginPage.fpEmailInput
    Then click LoginPage.fpSubmitButton

  Scenario: Forgot password process for invalid email
    Given navigate to page "login"
    When click LoginPage.forgotPassLink

    # redirected to FP page
    Then write "invalid_mail@invalid.com" into LoginPage.fpEmailInput
    Then click LoginPage.fpSubmitButton
    Then LoginPage.alertBox has text "The email does not exist."

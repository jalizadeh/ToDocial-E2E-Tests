@e2e
@TTS_A
@ignore
Feature: Homepage (anonymous user)

  Scenario: Verify elements presence
    Given navigate to homepage

    Then check presence of Menu.HomeButton
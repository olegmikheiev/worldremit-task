Feature: Apply for a position on the careers page
  As a user
  I would like to apply for a given position
  So that company can receive my application

  Scenario: As a user, I would like to apply for a given position
    #Given I enter 'https://www.worldremit.com/en/careers'
    Given I am on the careers page
    When I go to open position form
    And I select a department 'Engineering & IT'
    And I select an office as 'Kraków'
    And I find a position for 'QA'
    And I open 'QA' position
    And I fill in an application form without a resume
    And I click on apply now
    Then Validation error 'Please attach a resume.' is displayed

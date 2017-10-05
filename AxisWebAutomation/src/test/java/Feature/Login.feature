Feature: LoginFeature
  This feature deals with the login with Valid Credentials

  Scenario: Login with Valid Credentials
    Given I navigate to the login page of Axis Web
    And I enter the following credentials
      | username                       | password  |
      | abhijeet.daspatnaik@massive.co | ABHI@dp11 |
    And I click on Login button
    Then I should see the Axis Home page
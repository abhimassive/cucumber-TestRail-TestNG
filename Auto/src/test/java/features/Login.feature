Feature: Login
  User SHOULD NOT be able to login with INCORRECT credentials
  User SHOULD be able to login only with CORRECT credentials


  Scenario Outline: As a user I want to login to Axis Responsive Web Application
    Given I navigate to Axis RWA
    When I click on Sign In
    And I Login with incorrect Email and Password
    Then I should see an Unsuccessful login message: "Looks like your email or password is incorrect. Please try again."
    But When I Login with correct "<email>" and "<password>"
    Then I should Successfully login and see my account badge with the first letter of my "<email>" in uppercase


    Examples:
      | email                          | password  |
      | abhijeet.daspatnaik@massive.co | ABHI@dp11 |
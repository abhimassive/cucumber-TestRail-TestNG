Feature: User should be able to view Movies sorted from A to Z


  Scenario: I have a web browser and internet connection

    Given I am on the AXIS RWA HOMEpage
    When I hover my mouse over MOVIES link
    Then A drop down frame appears containing option A-Z
    And I click on the A-Z option
    Then Movies are sorted alphabetically from A-Z

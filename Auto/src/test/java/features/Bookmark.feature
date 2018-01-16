Feature: Bookmark items


  Scenario: As a logged in user I should be able to Bookmark items

    Given I am logged in into AXIS RWA
    When I open up an item
    And I click on the Bookmark button
    Then the item should be saved to my Bookmark history

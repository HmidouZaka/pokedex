Feature: Favourite Functionality

  Scenario: Add to FavouriteList
    Given I am on the Homepage
    When I press the favourite logo on a Pokemon
    Then the pokemon selected should be on the Favouritelist.


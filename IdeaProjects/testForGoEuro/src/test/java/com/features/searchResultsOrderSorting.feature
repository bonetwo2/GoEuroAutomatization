Feature: Sorting the order of search results
As a user I would like to search for for a travel route
So that the results shown to me are sorted by a selected category

 ### Task no. 2 ###

### Background ###

  Scenario: search for a trip
  Given I am on the homepage
  When  I search for a trip from (.*) to (.*)
  Then  I am on the search results page

### Scenarios ###

  Scenario: sort search results by price

  When  I list the search result's prices
  Then  the results should be ordered from the cheapest to the most expensive




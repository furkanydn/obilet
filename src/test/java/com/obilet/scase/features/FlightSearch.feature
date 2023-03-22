Feature: Flight Ticket Search
  Scenario: By entering the Obilet home page, click on the Flights tab and see that the flight ticket search page opens.
    Given Click on the Flight Tab
    When The flight ticket search page must be open.
    Then There will be a display of the flight search page.

  Scenario: Select a departure city and departure date, a return city and return date.
    Given The city and date will be the selection.
    When UI components display the selected values.
    Then Actions are performed on the selected values.

  Scenario: Once you have made your selections, click the Search Flights button and the flights will be listed.
    Given The required flight information is expected to be complete.
    When Search button is clicked, actions must be taken.
    Then It is observed that flights are listed.

  Scenario: Any departure flight will be selected from the flights
    Given The selection is made when flights are observed to be loaded.
    When The desired departure flight is selected according to the ranking.
    Then The departure flight is selected.

  Scenario: Any return flight will be selected from the flights
    Given The selection is made when flights are observed to be loaded.
    When The desired return flight is selected according to the ranking.
    Then The return flight is selected.

  Scenario: The successful opening of the payment page confirms that the roundtrip flight on the payment page is the selected roundtrip flight.
    Given Payment will be verified upon successful opening of the page.
    When Confirm that the round-trip flight on the payment page is the selected round-trip flight.
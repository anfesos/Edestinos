Feature: This feature permite reserve a flight in the web page Edestinos
  I how user the web Edestinos
  Want reserve a flight
  For guarantee my ticket on the flight

  @BookRoundTripFlight
  Scenario Outline: Book round trip flight
    Given The user is on the Edestinos website
    When Enter your reservation details to Book Round Trip Flight from dataSet <dataset>
    Then the chair in dataser is reserved

    Examples:
      | dataset                                                |
      | .\src\test\resources\templates\flight_information.xlsx |



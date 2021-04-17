Feature: This feature permite reserve a flight in the web page Edestinos
  I how user the web Edestinos
  Want reserve a flight
  For guarantee my ticket on the flight

  @BookOneWayTicket
  Scenario: Book one way ticket
    Given The user is on the Edestinos website
    When book the one-way ticket with the reservation details
      | origen                           | destino      | salida     |
      | Medellín (Todos los Aeropuertos) | Cancún (CUN) | 2021-05-19 |
    Then the chair is reserved

  @BookRoundTripFlight
  Scenario: Book round trip flight
    Given The user is on the Edestinos website
    When Enter your reservation details to Book Round Trip Flight
      | origen                           | destino      | salida     | regreso    | cantidadPasajerosAdultos | cantidadPasajerosJovenes | cantidadPasajerosNinos | cantidadPasajerosBebes |
      | Medellín (Todos los Aeropuertos) | Cancún (CUN) | 2021-05-19 | 2021-05-28 | 2                        | 3                        | 1                      | 1                      |
    Then the chair is reserved


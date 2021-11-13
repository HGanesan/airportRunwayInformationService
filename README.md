AirportRunwayInformationService:
===============================
- Runways for each airport given a country code or country name.

  GET     /runway/countryCode (nl.airport.runway.controller.CountryController)
  GET     /runway/countryName (nl.airport.runway.controller.CountryController)

- Top 10 countries with highest number of airports.

  GET     /countries/airport (nl.airport.runway.controller.CountryController)

The application can be run in the IntelliJ with the config.yml file(IntelliJ configuration image attached (img.png)).

REGRESSION SUITE:
================
- airportRunwayInformationService/ari-engine/RegressionSuite/AirportRunwayInformationService.postman_collection.json


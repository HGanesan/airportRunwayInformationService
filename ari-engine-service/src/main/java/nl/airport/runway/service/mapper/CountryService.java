package nl.airport.runway.service.mapper;

import nl.airport.runway.core.Airport;
import nl.airport.runway.core.Country;
import nl.airport.runway.core.Runway;
import nl.airport.runway.service.config.AriConfig;
import nl.airport.runway.service.exception.NoAirportFoundException;
import nl.airport.runway.service.exception.NoCountryFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    final AriConfig ariConfig;

    public CountryService() {
        this.ariConfig = AriConfig.getInstance();
    }

    protected CountryService(AriConfig ariConfig) {
        this.ariConfig = ariConfig;
    }

    /**
     * Method to get the runway details with the countryCode.
     *
     * @param countryCode country code.
     * @return - List of runways.
     * @throws NoAirportFoundException
     */
    public List<Runway> processRunwayWithCountryCode(String countryCode) throws NoAirportFoundException {
        return getRunwayDetails(countryCode);
    }

    /**
     * Method to get the runway details with the countryName.
     *
     * @param countryName - country name.
     * @return - List of runways.
     * @throws NoAirportFoundException
     * @throws NoCountryFoundException
     */
    public List<Runway> processRunwayWithCountryName(String countryName) throws NoAirportFoundException, NoCountryFoundException {
        try {
            Optional<Country> countryObject = ariConfig.getCountries()
                    .parallelStream()
                    .filter(c -> (c.getName().equalsIgnoreCase(countryName) || c.getName().contains(countryName)))
                    .findFirst();
            if (countryObject.isPresent()) {
                Country country = countryObject.get();
                return getRunwayDetails(country.getCode());
            }
            throw new NoSuchElementException();
        } catch (NoSuchElementException e) {
            LOGGER.error("No country found in the list for countryName:{}", countryName);
            throw new NoCountryFoundException("No details found for the country");
        }
    }

    /**
     * Method to process the countries with highest number of airports.
     *
     * @param count - Count to get the highest number of countries.
     * @return - List of countries.
     */
    public List<String> processCountriesWithHighestNumberOfAirports(int count) {
        Map<String, Integer> countriesWithHighestAirports = ariConfig.getCountryWithAirportCountMap().entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return countriesWithHighestAirports.keySet().stream()
                .limit(count)
                .collect(Collectors.toList());
    }

    private List<Runway> getRunwayDetails(String countryCode) throws NoAirportFoundException {
        List<Airport> airports = ariConfig.getCountryAirportMap().get(countryCode);
        if (!airports.isEmpty()) {
            List<Runway> runways = new ArrayList<>();
            for (Airport airport : airports) {
                if (ariConfig.getAirportRunwayMap().containsKey(airport.getId())) {
                    runways.addAll(ariConfig.getAirportRunwayMap().get(airport.getId()));
                }
            }
            return runways;
        }
        LOGGER.error("No airport found for the country code:{}", countryCode);
        throw new NoAirportFoundException("No airport found for the countryCode");
    }
}

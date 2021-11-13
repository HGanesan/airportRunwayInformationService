package nl.airport.runway.service.config;

import nl.airport.runway.core.Airport;
import nl.airport.runway.core.Country;
import nl.airport.runway.core.Runway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AriConfig {

    private List<Runway> runways;
    private List<Country> countries;
    private List<Airport> airports;
    private Map<String, List<Runway>> airportRunwayMap = new HashMap<String, List<Runway>>();
    private Map<String, List<Airport>> countryAirportMap = new HashMap<String, List<Airport>>();
    private Map<String, Integer> countryWithAirportCountMap = new HashMap<String, Integer>();


    /**
     * LazyHolder for making the Singleton pattern Thread safe.
     */
    private static class LazyHolder {
        static final AriConfig INSTANCE = new AriConfig();
    }

    public static AriConfig getInstance() {
        return LazyHolder.INSTANCE;
    }

    public List<Runway> getRunways() {
        return runways;
    }

    public void setRunways(List<Runway> runways) {
        this.runways = runways;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public Map<String, List<Runway>> getAirportRunwayMap() {
        return airportRunwayMap;
    }

    public void setAirportRunwayMap(Map<String, List<Runway>> airportRunwayMap) {
        this.airportRunwayMap = airportRunwayMap;
    }

    public Map<String, List<Airport>> getCountryAirportMap() {
        return countryAirportMap;
    }

    public void setCountryAirportMap(Map<String, List<Airport>> countryAirportMap) {
        this.countryAirportMap = countryAirportMap;
    }

    public Map<String, Integer> getCountryWithAirportCountMap() {
        return countryWithAirportCountMap;
    }

    public void setCountryWithAirportCountMap(Map<String, Integer> countryWithAirportCountMap) {
        this.countryWithAirportCountMap = countryWithAirportCountMap;
    }
}

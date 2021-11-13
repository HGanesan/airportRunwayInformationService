package nl.airport.runway.service.mapper;


import nl.airport.runway.core.Airport;
import nl.airport.runway.core.Country;
import nl.airport.runway.service.config.AriConfig;
import nl.airport.runway.service.exception.NoAirportFoundException;
import nl.airport.runway.service.exception.NoCountryFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

public class CountryServiceTest {


    private CountryService countryService;

    @Mock
    private AriConfig ariConfig;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.countryService = new CountryService(ariConfig);
    }

    @Test
    public void testProcessRunwayWithCountryCode() throws Exception {
        List<Airport> airports=new ArrayList<>();
        airports.add(new Airport());
        Map<String , List<Airport>> countryAirportMap=new HashMap<String , List<Airport>>();
        countryAirportMap.put("1",airports);
        when(ariConfig.getCountryAirportMap()).thenReturn(countryAirportMap);

        countryService.processRunwayWithCountryCode("1");
    }

    @Test(expected = NoAirportFoundException.class)
    public void testProcessRunwayWithCountryCodeException() throws Exception {
        Map<String , List<Airport>> countryAirportMap=new HashMap<String , List<Airport>>();
        countryAirportMap.put("1",new ArrayList<>());
        when(ariConfig.getCountryAirportMap()).thenReturn(countryAirportMap);

        countryService.processRunwayWithCountryCode("1");
    }

    @Test
    public void testProcessRunwayWithCountryName() throws Exception {
        List<Country> countries=new ArrayList<>();
        Country country=new Country();
        country.setCode("1");
        country.setName("United States");
        countries.add(country);
        when(ariConfig.getCountries()).thenReturn(countries);

        List<Airport> airports=new ArrayList<>();
        airports.add(new Airport());
        Map<String , List<Airport>> countryAirportMap=new HashMap<String , List<Airport>>();
        countryAirportMap.put("1",airports);
        when(ariConfig.getCountryAirportMap()).thenReturn(countryAirportMap);

        countryService.processRunwayWithCountryName("United States");
    }

    @Test(expected = NoAirportFoundException.class)
    public void testProcessRunwayWithCountryNameException1() throws Exception {
        List<Country> countries=new ArrayList<>();
        Country country=new Country();
        country.setCode("1");
        country.setName("United States");
        countries.add(country);
        when(ariConfig.getCountries()).thenReturn(countries);

        Map<String , List<Airport>> countryAirportMap=new HashMap<String , List<Airport>>();
        countryAirportMap.put("1",new ArrayList<>());
        when(ariConfig.getCountryAirportMap()).thenReturn(countryAirportMap);

        countryService.processRunwayWithCountryName("United States");
    }

    @Test(expected = NoCountryFoundException.class)
    public void testProcessRunwayWithCountryNameException2() throws Exception {
        when(ariConfig.getCountries()).thenReturn(new ArrayList<>());
        countryService.processRunwayWithCountryName("United States");
    }

    @Test
    public void testProcessCountriesWithHighestNumberOfAirports() {
        countryService.processCountriesWithHighestNumberOfAirports(10);
    }

}
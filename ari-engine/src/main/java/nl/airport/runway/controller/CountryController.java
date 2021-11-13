package nl.airport.runway.controller;

import io.dropwizard.jersey.caching.CacheControl;
import nl.airport.runway.core.Runway;
import nl.airport.runway.service.exception.NoAirportFoundException;
import nl.airport.runway.service.exception.NoCountryFoundException;
import nl.airport.runway.service.mapper.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static nl.airport.runway.mapper.RequestMapping.COUNTRIES_AIRPORT;
import static nl.airport.runway.mapper.RequestMapping.COUNTRY_CODE;
import static nl.airport.runway.mapper.RequestMapping.COUNTRY_NAME;

@Path("/")
@Produces(APPLICATION_JSON)

public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Inject
    private CountryService countryService;

    @GET
    @Path(COUNTRY_CODE)
    @CacheControl(noCache = true, noStore = true)
    public List<Runway> getRunwayDetailsWithCountryCode(@Context UriInfo uriInfo,
                                                        @NotNull @QueryParam("countryCode") String countryCode) throws NoAirportFoundException {
        LOGGER.info("Process runway details with country code:{}", countryCode);
        return countryService.processRunwayWithCountryCode(countryCode);
    }

    @GET
    @Path(COUNTRY_NAME)
    @CacheControl(noCache = true, noStore = true)
    public List<Runway> getRunwayDetailsWithCountryName(@Context UriInfo uriInfo,
                                                        @NotNull @QueryParam("countryName") String countryName) throws NoCountryFoundException, NoAirportFoundException {
        LOGGER.info("Process runway details with country name:{}", countryName);
        return countryService.processRunwayWithCountryName(countryName);
    }

    @GET
    @Path(COUNTRIES_AIRPORT)
    @CacheControl(noCache = true, noStore = true)
    public List<String> getCountriesWithHighestNumberOfAirports(@Context UriInfo uriInfo, @DefaultValue("10") @QueryParam("count") int count) {
        LOGGER.info("Get the countries with highest number of airports");
        return countryService.processCountriesWithHighestNumberOfAirports(count);
    }


}

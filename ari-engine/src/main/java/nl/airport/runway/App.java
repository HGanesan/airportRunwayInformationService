package nl.airport.runway;

import com.opencsv.bean.CsvToBeanBuilder;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.web.WebBundle;
import io.dropwizard.web.conf.WebConfiguration;
import nl.airport.runway.config.AriServiceConfiguration;
import nl.airport.runway.controller.CountryController;
import nl.airport.runway.core.Airport;
import nl.airport.runway.core.Country;
import nl.airport.runway.core.Runway;
import nl.airport.runway.mapper.ExceptionHandler;
import nl.airport.runway.service.config.AriConfig;
import org.glassfish.jersey.logging.LoggingFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class App extends Application<AriServiceConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        // Start the application
        new App().run(args);
    }

    @Override
    public void run(AriServiceConfiguration configuration, Environment environment) throws Exception {
        LOGGER.info("Initialization of registration ");

        // Initialize configuration for other project's within TDP.
        initConfig(configuration);

        environment.jersey().register(new AppInjectBinder());

        // Registration of the handlers / mappings
        environment.jersey().register(new ExceptionHandler());

        // Logging inbound request/response
        environment.jersey().register(new LoggingFeature(java.util.logging.Logger.getLogger("nl.airport.runway.logging"),
                Level.FINE, LoggingFeature.Verbosity.PAYLOAD_TEXT, 1000));

        //registering controllers
        environment.jersey().register(CountryController.class);
    }

    private void initConfig(AriServiceConfiguration config) throws Exception {
        LOGGER.info("Initialization of configuration");

        loadCountryConfiguration(config.getCsvCountryResourcePath());
        loadAirportConfiguration(config.getCsvAirportResourcePath());
        loadRunwayConfiguration(config.getCsvRunwayResourcePath());

        processCountryAirportRunwayDetails();
    }

    private void loadRunwayConfiguration(String configFile) throws Exception {
        AriConfig ariConfig = AriConfig.getInstance();

        LOGGER.info("Load runway configuration file: " + configFile);

        try (FileReader file = getFile(configFile)) {
            List<Runway> runways = new CsvToBeanBuilder(file)
                    .withType(Runway.class)
                    .build()
                    .parse();

            LOGGER.info("Size of stored runway items is: {}", runways.size());
            ariConfig.setRunways(runways);

        } catch (IOException e) {
            LOGGER.error("Cannot load runway config file : " + configFile);
            throw e;
        }

    }

    private void loadCountryConfiguration(String configFile) throws Exception {
        AriConfig ariConfig = AriConfig.getInstance();

        LOGGER.info("Load country configuration file: " + configFile);

        try (FileReader file = getFile(configFile)) {
            List<Country> countries = new CsvToBeanBuilder(file)
                    .withType(Country.class)
                    .build()
                    .parse();

            LOGGER.info("Size of stored country items is: {}", countries.size());
            ariConfig.setCountries(countries);
        } catch (IOException e) {
            LOGGER.error("Cannot load country config file : " + configFile);
            throw e;
        }
    }

    private void loadAirportConfiguration(String configFile) throws Exception {
        AriConfig ariConfig = AriConfig.getInstance();

        LOGGER.info("Load airport configuration file: " + configFile);

        try (FileReader file = getFile(configFile)) {
            List<Airport> airports = new CsvToBeanBuilder(file)
                    .withType(Airport.class)
                    .build()
                    .parse();

            LOGGER.info("Size of stored airport items is: {}", airports.size());
            ariConfig.setAirports(airports);
        } catch (IOException e) {
            LOGGER.error("Cannot load airport config file : " + configFile);
            throw e;
        }
    }

    private void processCountryAirportRunwayDetails() {
        AriConfig ariConfig = AriConfig.getInstance();

        LOGGER.info("Process airportRunway details");
        for (Airport airport : ariConfig.getAirports()) {
            List<Runway> airportRunways = ariConfig.getRunways()
                    .stream()
                    .filter(c -> c.getAirport_ref().equalsIgnoreCase(airport.getId()))
                    .collect(Collectors.toList());
            ariConfig.getAirportRunwayMap().put(airport.getId(), airportRunways);
        }
        LOGGER.info("Process countryAirport details");
        for (Country country : ariConfig.getCountries()) {
            List<Airport> countryAirports = ariConfig.getAirports()
                    .stream()
                    .filter(c -> c.getIso_country().equalsIgnoreCase(country.getCode()))
                    .collect(Collectors.toList());

            ariConfig.getCountryAirportMap().put(country.getCode(), countryAirports);
            ariConfig.getCountryWithAirportCountMap().put(country.getCode(),countryAirports.size());
        }
    }

    @Override
    public void initialize(Bootstrap<AriServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new WebBundle<AriServiceConfiguration>() {
            @Override
            public WebConfiguration getWebConfiguration(final AriServiceConfiguration ariServiceConfiguration) {
                return ariServiceConfiguration.getWebConfiguration();
            }
        });
    }

    private FileReader getFile(String configFile) throws FileNotFoundException {
        return new FileReader(configFile);
    }
}

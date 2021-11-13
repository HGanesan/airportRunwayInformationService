package nl.airport.runway.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.web.conf.WebConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class AriServiceConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty("web")
    private WebConfiguration webConfiguration = new WebConfiguration();

    @NotNull
    private String csvAirportResourcePath;

    @NotNull
    private String csvRunwayResourcePath;

    @NotNull
    private String csvCountryResourcePath;

    public WebConfiguration getWebConfiguration() {
        return webConfiguration;
    }

    public void setWebConfiguration(WebConfiguration webConfiguration) {
        this.webConfiguration = webConfiguration;
    }

    public String getCsvAirportResourcePath() {
        return csvAirportResourcePath;
    }

    public void setCsvAirportResourcePath(String csvAirportResourcePath) {
        this.csvAirportResourcePath = csvAirportResourcePath;
    }

    public String getCsvRunwayResourcePath() {
        return csvRunwayResourcePath;
    }

    public void setCsvRunwayResourcePath(String csvRunwayResourcePath) {
        this.csvRunwayResourcePath = csvRunwayResourcePath;
    }

    public String getCsvCountryResourcePath() {
        return csvCountryResourcePath;
    }

    public void setCsvCountryResourcePath(String csvCountryResourcePath) {
        this.csvCountryResourcePath = csvCountryResourcePath;
    }
}

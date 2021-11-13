package nl.airport.runway;


import nl.airport.runway.service.mapper.CountryService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;


public class AppInjectBinder extends AbstractBinder {

    @Override
    protected void configure() {

        // business service
        bind(CountryService.class).to(CountryService.class);

    }
}



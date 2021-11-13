package nl.airport.runway.mapper;

import nl.airport.runway.service.exception.NoAirportFoundException;
import nl.airport.runway.service.exception.NoCountryFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class ExceptionHandler implements ExceptionMapper<Exception> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public Response toResponse(final Exception exception) {
        LOGGER.info("Inside exception handler : {}", exception.getMessage());
        Response.Status status = Response.Status.INTERNAL_SERVER_ERROR;
        String errorResponse = "Error occurred while processing your request";
        if (exception instanceof NoCountryFoundException || exception instanceof NoAirportFoundException) {
            status = Response.Status.NOT_FOUND;
            errorResponse = exception.getMessage();
        }
        return Response.status(status).header("Content-Type", MediaType.TEXT_HTML).entity(errorResponse)
                .build();
    }
}

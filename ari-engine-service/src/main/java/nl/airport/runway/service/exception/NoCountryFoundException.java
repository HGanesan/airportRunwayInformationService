package nl.airport.runway.service.exception;

public class NoCountryFoundException extends Exception {
    /**
     * Serial version id.
     */
    private static final long serialVersionUID = 1L;

    public NoCountryFoundException(String message) {
        super(message);
    }
}

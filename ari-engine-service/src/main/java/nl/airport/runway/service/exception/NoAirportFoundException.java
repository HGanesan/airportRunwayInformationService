package nl.airport.runway.service.exception;

public class NoAirportFoundException extends Exception {
    /**
     * Serial version id.
     */
    private static final long serialVersionUID = 1L;

    public NoAirportFoundException(String message) {
        super(message);
    }
}

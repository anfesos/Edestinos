package co.com.edestinos.vuelos.exceptions;

import net.serenitybdd.core.exceptions.SerenityManagedException;

public class InformationBookRoundTripFlightException extends SerenityManagedException {

    public static final String MESSAGE_ERROR_BOOK_ROUND_TRIP = "Error in the information for reservation Book round trip flight";

    public InformationBookRoundTripFlightException(String message, Throwable testErrorException) {
        super(message, testErrorException);
    }
}

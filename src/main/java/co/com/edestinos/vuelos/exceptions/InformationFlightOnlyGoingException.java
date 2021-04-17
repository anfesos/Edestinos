package co.com.edestinos.vuelos.exceptions;

import net.serenitybdd.core.exceptions.SerenityManagedException;

public class InformationFlightOnlyGoingException extends SerenityManagedException {

    public static String ERROR_ONLY_GOING_INFOMATION = "Error in the information for reservation only going";
    public InformationFlightOnlyGoingException(String message, Throwable testErrorException) {
        super(message, testErrorException);
    }
}

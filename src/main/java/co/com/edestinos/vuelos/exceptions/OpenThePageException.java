package co.com.edestinos.vuelos.exceptions;

import net.serenitybdd.core.exceptions.SerenityManagedException;

public class OpenThePageException extends SerenityManagedException {

    public static String OPEN_PAGE_EXCEPTION = "Exception generated opening the page";
    public OpenThePageException(String message, Throwable testErrorException) {
        super(message, testErrorException);
    }
}

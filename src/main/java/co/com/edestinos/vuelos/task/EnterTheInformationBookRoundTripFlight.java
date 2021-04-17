package co.com.edestinos.vuelos.task;

import co.com.edestinos.vuelos.exceptions.InformationFlightOnlyGoingException;
import co.com.edestinos.vuelos.interactions.EnterInformationJs;
import co.com.edestinos.vuelos.interactions.NumberPassengers;
import co.com.edestinos.vuelos.interactions.TypeOperation;
import co.com.edestinos.vuelos.interactions.TypePassenger;
import co.com.edestinos.vuelos.models.ReservationDetails;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;

import static co.com.edestinos.vuelos.exceptions.InformationBookRoundTripFlightException.MESSAGE_ERROR_BOOK_ROUND_TRIP;
import static co.com.edestinos.vuelos.userinterfaces.InitPage.*;
import static co.com.edestinos.vuelos.userinterfaces.InitPage.BUSCAR_VUELO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EnterTheInformationBookRoundTripFlight implements Task {

    private ReservationDetails reservationDetails;
    private static int posicion = 0;

    public EnterTheInformationBookRoundTripFlight(ReservationDetails reservationDetails) {
        this.reservationDetails = reservationDetails;
        posicion++;
    }

    public static int getPosicion() {
        return posicion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Enter.theValue(reservationDetails.getOrigen() + "\n").into(ORIGEN_IDA_Y_VUELTA),
                    Enter.theValue(reservationDetails.getDestino() + "\n").into(DESTINO_IDA_Y_VUELTA)
            );

            actor.attemptsTo(
                    EnterInformationJs.inTextArea(SALIDA_IDA_Y_VUELTA, reservationDetails.getSalida()),
                    EnterInformationJs.inTextArea(REGRESO_IDA_Y_VUELTA, reservationDetails.getRegreso())
            );

            actor.attemptsTo(
                    Click.on(PASAJEROS)
            );


            addAdultPassengers();

            addYoungPassengers();

            addChildPassengers();

            addInfantPassengers();

            actor.attemptsTo(Click.on(APLICAR_CAMBIOS_PASAJEROS));

            actor.attemptsTo(
                    Click.on(BUSCAR_VUELO)
            );


        } catch (Exception e) {
            throw new InformationFlightOnlyGoingException(MESSAGE_ERROR_BOOK_ROUND_TRIP, e);
        }
    }

    private void addChildPassengers() {

        if (reservationDetails.getCantidadPasajerosNinos() > 0) {
            theActorInTheSpotlight().attemptsTo(
                    NumberPassengers.inFlight(TypePassenger.CHILD.toString(), TypeOperation.PLUS.toString(), reservationDetails.getCantidadPasajerosNinos())
            );
        }
    }

    private void addInfantPassengers() {

        theActorInTheSpotlight().attemptsTo(Scroll.to(BUSCAR_VUELO));

        if (reservationDetails.getCantidadPasajerosBebes() > 0) {
            theActorInTheSpotlight().attemptsTo(
                    NumberPassengers.inFlight(TypePassenger.INFANT.toString(), TypeOperation.PLUS.toString(), reservationDetails.getCantidadPasajerosBebes())
            );
        }

    }

    private void addYoungPassengers() {

        if (reservationDetails.getCantidadPasajerosJovenes() > 0) {
            theActorInTheSpotlight().attemptsTo(
                    NumberPassengers.inFlight(TypePassenger.YOUNG.toString(), TypeOperation.PLUS.toString(), reservationDetails.getCantidadPasajerosJovenes())
            );
        }

    }

    private void addAdultPassengers() {

        if (reservationDetails.getCantidadPasajerosAdultos() > 1) {
            theActorInTheSpotlight().attemptsTo(
                    NumberPassengers.inFlight(TypePassenger.ADULT.toString(), TypeOperation.PLUS.toString(), reservationDetails.getCantidadPasajerosAdultos()-1)
            );
        }
    }

    public static EnterTheInformationBookRoundTripFlight intoWebPage(ReservationDetails reservationDetails) {
        return instrumented(EnterTheInformationBookRoundTripFlight.class, reservationDetails);
    }
}

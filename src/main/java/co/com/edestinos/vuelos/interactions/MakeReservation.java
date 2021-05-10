package co.com.edestinos.vuelos.interactions;

import co.com.edestinos.vuelos.exceptions.InformationFlightOnlyGoingException;
import co.com.edestinos.vuelos.models.Reservation;
import co.com.edestinos.vuelos.models.ReservationDetails;
import co.com.edestinos.vuelos.models.ReservationDetailsExcel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.HashMap;
import java.util.Map;

import static co.com.edestinos.vuelos.exceptions.InformationBookRoundTripFlightException.MESSAGE_ERROR_BOOK_ROUND_TRIP;
import static co.com.edestinos.vuelos.userinterfaces.InitPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class MakeReservation implements Interaction {

    private Reservation reservationDetails;
    private ReservationDetails reservationDetailsFeature;
    private ReservationDetailsExcel reservationDetailsExcel;
    private boolean flagReservation;
    private static Map<String,Boolean> resultExecution = new HashMap<>();

    public MakeReservation(ReservationDetailsExcel reservationDetails) {
        this.reservationDetails = reservationDetails;
        this.reservationDetailsExcel = reservationDetails;
        flagReservation = false;
    }

    public MakeReservation(ReservationDetails reservationDetails) {
        this.reservationDetails = reservationDetails;
        this.reservationDetailsFeature = reservationDetails;
        flagReservation = true;
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

            resultExecution.put(reservationDetails.getOrigen(),true);

        } catch (Exception e) {
            resultExecution.put(reservationDetails.getOrigen(),false);
            throw new InformationFlightOnlyGoingException(MESSAGE_ERROR_BOOK_ROUND_TRIP, e);
        }
    }

    private void addChildPassengers() {

        if(flagReservation){
            if (reservationDetailsFeature.getCantidadPasajerosNinos() > 0) {
                theActorInTheSpotlight().attemptsTo(
                        NumberPassengers.inFlight(TypePassenger.CHILD.toString(), TypeOperation.PLUS.toString(), reservationDetailsFeature.getCantidadPasajerosNinos())
                );
            }
        }else{
            if (Integer.parseInt(reservationDetailsExcel.getCantidadPasajerosNinos()) > 0) {
                theActorInTheSpotlight().attemptsTo(
                        NumberPassengers.inFlight(TypePassenger.CHILD.toString(), TypeOperation.PLUS.toString(), Integer.parseInt(reservationDetailsExcel.getCantidadPasajerosNinos()))
                );
            }
        }
    }

    private void addInfantPassengers() {

        theActorInTheSpotlight().attemptsTo(Scroll.to(BUSCAR_VUELO));

        if(flagReservation){
            if (reservationDetailsFeature.getCantidadPasajerosBebes() > 0) {
                theActorInTheSpotlight().attemptsTo(
                        NumberPassengers.inFlight(TypePassenger.INFANT.toString(), TypeOperation.PLUS.toString(), reservationDetailsFeature.getCantidadPasajerosBebes())
                );
            }
        }else{
            if (Integer.parseInt(reservationDetailsExcel.getCantidadPasajerosBebes()) > 0) {
                theActorInTheSpotlight().attemptsTo(
                        NumberPassengers.inFlight(TypePassenger.INFANT.toString(), TypeOperation.PLUS.toString(), Integer.parseInt(reservationDetailsExcel.getCantidadPasajerosBebes()))
                );
            }
        }

    }

    private void addYoungPassengers() {

        if(flagReservation){
            if (reservationDetailsFeature.getCantidadPasajerosJovenes() > 0) {
                theActorInTheSpotlight().attemptsTo(
                        NumberPassengers.inFlight(TypePassenger.YOUNG.toString(), TypeOperation.PLUS.toString(), reservationDetailsFeature.getCantidadPasajerosJovenes())
                );
            }
        }else{
            if (Integer.parseInt(reservationDetailsExcel.getCantidadPasajerosJovenes()) > 0) {
                theActorInTheSpotlight().attemptsTo(
                        NumberPassengers.inFlight(TypePassenger.YOUNG.toString(), TypeOperation.PLUS.toString(), Integer.parseInt(reservationDetailsExcel.getCantidadPasajerosJovenes()))
                );
            }
        }
    }

    private void addAdultPassengers() {

        if(flagReservation){
            if (reservationDetailsFeature.getCantidadPasajerosAdultos() > 1) {
                theActorInTheSpotlight().attemptsTo(
                        NumberPassengers.inFlight(TypePassenger.ADULT.toString(), TypeOperation.PLUS.toString(), reservationDetailsFeature.getCantidadPasajerosAdultos()-1)
                );
            }
        }else{
            if (Integer.parseInt(reservationDetailsExcel.getCantidadPasajerosAdultos()) > 1) {
                theActorInTheSpotlight().attemptsTo(
                        NumberPassengers.inFlight(TypePassenger.ADULT.toString(), TypeOperation.PLUS.toString(), Integer.parseInt(reservationDetailsExcel.getCantidadPasajerosAdultos())-1)
                );
            }
        }
    }

    public static Map<String, Boolean> getResultExecution() {
        return resultExecution;
    }

    public static MakeReservation intoWebPage(ReservationDetails reservationDetails){
        return new MakeReservation(reservationDetails);
    }

    public static MakeReservation intoWebPage(ReservationDetailsExcel reservationDetails) {
        return new MakeReservation(reservationDetails);
    }
}

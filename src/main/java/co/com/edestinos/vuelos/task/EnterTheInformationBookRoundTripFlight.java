package co.com.edestinos.vuelos.task;

import co.com.edestinos.vuelos.interactions.MakeReservation;
import co.com.edestinos.vuelos.models.ReservationDetails;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

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
        actor.attemptsTo(MakeReservation.intoWebPage(reservationDetails));
    }

    public static EnterTheInformationBookRoundTripFlight intoWebPage(ReservationDetails reservationDetails) {
        return instrumented(EnterTheInformationBookRoundTripFlight.class, reservationDetails);
    }
}

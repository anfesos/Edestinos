package co.com.edestinos.vuelos.task;

import co.com.edestinos.vuelos.exceptions.InformationFlightOnlyGoingException;
import co.com.edestinos.vuelos.interactions.EnterInformationJs;
import co.com.edestinos.vuelos.models.ReservationDetails;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.edestinos.vuelos.exceptions.InformationFlightOnlyGoingException.ERROR_ONLY_GOING_INFOMATION;
import static co.com.edestinos.vuelos.userinterfaces.InitPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterTheInformationFlightOnlyGoing implements Task {

    private ReservationDetails reservationDetails;
    private static int position = 0;

    public EnterTheInformationFlightOnlyGoing(ReservationDetails reservationDetails) {
        this.reservationDetails = reservationDetails;
        position++;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Click.on(CHECK_SOLO_IDA),
                    Enter.theValue(reservationDetails.getOrigen() + "\n").into(ORIGEN_SOLO_IDA),
                    Enter.theValue(reservationDetails.getDestino() + "\n").into(DESTINO_SOLO_IDA)
            );

            actor.attemptsTo(EnterInformationJs.inTextArea(SALIDA_SOLO_IDA,reservationDetails.getSalida()));

           /* Una forma incial de usar el JavascriptExecutor
            WebDriver driver = SerenityWebdriverManager.inThisTestThread().getCurrentDriver();
            WebElement element = driver.findElement(By.xpath("//*[@id='departureDateOneway']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value=\'" + reservationDetails.getSalida() + "\'" ,element);
            */

            actor.attemptsTo(
                    Click.on(BUSCAR_VUELO)
            );

        } catch (Exception e) {
            throw new InformationFlightOnlyGoingException(ERROR_ONLY_GOING_INFOMATION, e);
        }
    }

    public static EnterTheInformationFlightOnlyGoing intoWebPage(ReservationDetails reservationDetails) {
        return instrumented(EnterTheInformationFlightOnlyGoing.class, reservationDetails);
    }

    public static int getPosition() {
        return position;
    }
}

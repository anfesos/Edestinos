package co.com.edestinos.vuelos.task;

import co.com.edestinos.vuelos.interactions.MakeReservation;
import co.com.edestinos.vuelos.models.ReservationDetails;
import co.com.edestinos.vuelos.models.ReservationDetailsExcel;
import co.com.edestinos.vuelos.utils.read_excel.read.ReadExcel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static co.com.edestinos.vuelos.utils.read_excel.read.ReadExcel.getListData;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterTheInformationFromExcel implements Task {

    private String dirExcel;

    public EnterTheInformationFromExcel(String dirExcel) {
        this.dirExcel = dirExcel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        new ReadExcel.Builder()
                .model(new ReservationDetailsExcel())
                .fileName(dirExcel)
                .headerRow(0)
                .sheetToRead("fligths")
                .build();

        for(ReservationDetailsExcel reservationDetails: (List<ReservationDetailsExcel>)(Object)getListData()){
            actor.attemptsTo(MakeReservation.intoWebPage(reservationDetails));
        }

    }

    public static EnterTheInformationFromExcel fromBookRoundTripFlight(String dirExcel) {
        return instrumented(EnterTheInformationFromExcel.class, dirExcel);
    }
}

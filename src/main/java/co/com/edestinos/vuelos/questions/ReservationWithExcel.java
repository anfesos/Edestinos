package co.com.edestinos.vuelos.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

import static co.com.edestinos.vuelos.interactions.MakeReservation.getResultExecution;

public class ReservationWithExcel implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result = true;
        for(Map.Entry<String,Boolean> map: getResultExecution().entrySet()){
            if(!map.getValue()){
                result = false;
                System.out.println("Fail" + map.getKey() + " ");
            }
        }

        return result;
    }
    public static ReservationWithExcel endedOk(){
        return new ReservationWithExcel();
    }
}

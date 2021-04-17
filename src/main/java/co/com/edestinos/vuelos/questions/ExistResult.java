package co.com.edestinos.vuelos.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.edestinos.vuelos.userinterfaces.InitPage.NUMERO_RESULTADOS;

public class ExistResult implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        return NUMERO_RESULTADOS.resolveFor(actor).getText().contains("resultado");
    }

    public static ExistResult forDates(){
        return new ExistResult();
    }
}

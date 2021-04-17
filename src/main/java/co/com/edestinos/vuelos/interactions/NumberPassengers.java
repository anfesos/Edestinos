package co.com.edestinos.vuelos.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.edestinos.vuelos.userinterfaces.InitPage.NUMERO_PASAJEROS;

public class NumberPassengers implements Interaction {

    private String typePassengerChoice;
    private int numberPassengers;
    private String typeOperation;

    public NumberPassengers(String typePassengerChoice, String typeOperation, int numberPassengers) {
        this.typePassengerChoice = typePassengerChoice;
        this.numberPassengers = numberPassengers;
        this.typeOperation = typeOperation;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        TypePassenger typePassenger = Enum.valueOf(TypePassenger.class, typePassengerChoice);
        TypeOperation typeOperation = Enum.valueOf(TypeOperation.class, this.typeOperation);

        for(int passangers = 1;passangers<=numberPassengers;passangers++){
            actor.attemptsTo(Click.on(NUMERO_PASAJEROS(typePassenger.getTypePassenger(), typeOperation.getTypeOperator())));
        }

    }

    public static NumberPassengers inFlight(String typePassengerChoice, String typeOperation, int numberPassengers) {
        return new NumberPassengers(typePassengerChoice, typeOperation, numberPassengers);
    }
}

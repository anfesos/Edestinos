package co.com.edestinos.vuelos.task;

import co.com.edestinos.vuelos.exceptions.OpenThePageException;
import co.com.edestinos.vuelos.userinterfaces.InitPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static co.com.edestinos.vuelos.exceptions.OpenThePageException.OPEN_PAGE_EXCEPTION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenThePage implements Task {

    private InitPage initPage;

    @Override
    public <T extends Actor> void performAs(T actor) {
        try{
            actor.attemptsTo(Open.browserOn(initPage));
        }catch (Exception e){
            throw new OpenThePageException(OPEN_PAGE_EXCEPTION,e);
        }
    }

    public static OpenThePage eDestinos(){
        return instrumented(OpenThePage.class);
    }
}

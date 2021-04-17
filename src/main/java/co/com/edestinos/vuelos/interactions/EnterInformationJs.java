package co.com.edestinos.vuelos.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class EnterInformationJs implements Interaction {
    private Target target;
    private String text;

    public EnterInformationJs(Target target,String text) {
        this.target = target;
        this.text = text;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).evaluateJavascript("arguments[0].value=\'" + text + "\'", target.resolveFor(actor));
    }

    public static EnterInformationJs inTextArea(Target target,String text){
        return new EnterInformationJs(target,text);
    }
}

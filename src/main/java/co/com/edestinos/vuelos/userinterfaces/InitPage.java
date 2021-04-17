package co.com.edestinos.vuelos.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InitPage extends PageObject {

    public static Target CHECK_SOLO_IDA = Target.the("check that select only going").located(By.xpath("//*[@id='TripTypeOneway']"));
    public static Target ORIGEN_SOLO_IDA = Target.the("Origen depart flight").located(By.xpath("//*[@id='departureOneway']"));
    public static Target DESTINO_SOLO_IDA = Target.the("Destino depart flight").located(By.xpath("//*[@id='arrivalOneway']"));
    public static Target SALIDA_SOLO_IDA = Target.the("Date depart flight").located(By.xpath("//*[@id='departureDateOneway']"));

    public static Target ORIGEN_IDA_Y_VUELTA = Target.the("Origen depart flight").located(By.xpath("//*[@id='departureRoundtrip0']"));
    public static Target DESTINO_IDA_Y_VUELTA  = Target.the("Destino depart flight").located(By.xpath("//*[@id='arrivalRoundtrip0']"));
    public static Target SALIDA_IDA_Y_VUELTA = Target.the("Date depart flight").located(By.xpath("//*[@id='departureDateRoundtrip0']"));
    public static Target REGRESO_IDA_Y_VUELTA = Target.the("Date return flight").located(By.xpath("//*[@id='departureDateRoundtrip1']"));

    public static Target PASAJEROS = Target.the("Select Passengers").located(By.xpath("//div[@class='wrap pax-widget custom-dropdown  ']"));

    public static Target NUMERO_PASAJEROS(String typePassenger,String typeOperation){
        return Target.the("number passengers to add or sustract").located(By.xpath("//div[@class='pax "+typePassenger+" ']//a[@class='"+typeOperation+"']"));
    }

    /*
    public static Target ADICIONAR_PASAJEROS_ADULTOS = Target.the("number adults passengers to add").located(By.xpath("//div[@class='pax adult ']//a[@class='plus']"));
    public static Target SUSTRAER_PASAJEROS_ADULTOS = Target.the("number adults passengers to sustract").located(By.xpath("//div[@class='pax adult ']//a[@class='minus']"));
    public static Target ADICIONAR_PASAJEROS_JOVENES = Target.the("number adults passengers to add").located(By.xpath("//div[@class='pax youth ']//a[@class='plus']"));
    public static Target SUSTRAER_PASAJEROS_JOVENES = Target.the("number young passengers to sustract").located(By.xpath("//div[@class='pax youth ']//a[@class='minus']"));
    public static Target ADICIONAR_PASAJEROS_NINOS = Target.the("number child passengers to add").located(By.xpath("//div[@class='pax child ']//a[@class='plus']"));
    public static Target SUSTRAER_PASAJEROS_NINOS = Target.the("number child passengers to sustract").located(By.xpath("//div[@class='pax child ']//a[@class='minus']"));
    public static Target ADICIONAR_PASAJEROS_BEBES = Target.the("number infant passengers to add").located(By.xpath("//div[@class='pax infant ']//a[@class='plus']"));
    public static Target SUSTRAER_PASAJEROS_BEBES = Target.the("number infant passengers to sustract").located(By.xpath("//div[@class='pax infant ']//a[@class='minus']"));
    */

    public static Target BUSCAR_VUELO = Target.the("button for search fligth").located(By.xpath("//button[@class='btn transaction qsf-search']"));

    public static Target APLICAR_CAMBIOS_PASAJEROS = Target.the("Button to apply choise for number passengers").located(By.xpath("//a[@Class='btn small function ghost close-pax-counter']"));

    public static Target NUMERO_RESULTADOS = Target.the("Result for request").located(By.xpath("//h6[contains(text(),'resultados')]"));
}

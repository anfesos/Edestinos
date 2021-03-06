package co.com.edestinos.vuelos.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/reserve_a_flight.feature",
        glue = "co.com.edestinos.vuelos.stepdefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = "@BookRoundTripFlight"
)
public class ReserveAFlight {
}

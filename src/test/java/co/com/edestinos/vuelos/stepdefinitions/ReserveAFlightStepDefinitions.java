package co.com.edestinos.vuelos.stepdefinitions;

import co.com.edestinos.vuelos.models.ReservationDetails;
import co.com.edestinos.vuelos.questions.ExistResult;
import co.com.edestinos.vuelos.task.EnterTheInformationBookRoundTripFlight;
import co.com.edestinos.vuelos.task.EnterTheInformationFlightOnlyGoing;
import co.com.edestinos.vuelos.task.OpenThePage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static co.com.edestinos.vuelos.task.EnterTheInformationFlightOnlyGoing.getPosition;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ReserveAFlightStepDefinitions {

    @Before
    public void setUp(){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Usuario");
    }

    @Given("^The user is on the Edestinos website$")
    public void theUserIsOnTheEdestinosWebsite() {
        theActorInTheSpotlight().wasAbleTo(OpenThePage.eDestinos());
    }


    @When("^book the one-way ticket with the reservation details$")
    public void bookTheOneWayTicketWithTheReservationDetails(List<ReservationDetails> reservationDetailsList) {
        theActorInTheSpotlight().attemptsTo(EnterTheInformationFlightOnlyGoing.intoWebPage(reservationDetailsList.get(EnterTheInformationFlightOnlyGoing.getPosition())));
    }

    @When("^Enter your reservation details to Book Round Trip Flight$")
    public void enterYourReservationDetailsToBookRoundTripFlight(List<ReservationDetails> reservationDetailsList) {
        theActorInTheSpotlight().attemptsTo(EnterTheInformationBookRoundTripFlight.intoWebPage(reservationDetailsList.get(EnterTheInformationBookRoundTripFlight.getPosicion())));
    }

    @Then("^the chair is reserved$")
    public void theChairIsReserved() {
        theActorInTheSpotlight().should(seeThat(ExistResult.forDates()));
    }
}

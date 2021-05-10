package co.com.edestinos.vuelos.stepdefinitions;

import co.com.edestinos.vuelos.questions.ReservationWithExcel;
import co.com.edestinos.vuelos.task.EnterTheInformationFromExcel;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ReserveAFlightExcelStepDefinitions {

    @Before
    public void setUp(){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("user");
    }

    @When("^Enter your reservation details to Book Round Trip Flight from dataSet (.*)$")
    public void enterYourReservationDetailsToBookRoundTripFlightFromDataSet(String dirExcel) {
        theActorInTheSpotlight().attemptsTo(EnterTheInformationFromExcel.fromBookRoundTripFlight(dirExcel));
    }


    @Then("^the chair in dataser is reserved$")
    public void theChairInDataserIsReserved() {
        theActorInTheSpotlight().should(seeThat(ReservationWithExcel.endedOk()));
    }
}

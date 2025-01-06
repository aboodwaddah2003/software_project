package GYM.AcceptanceTest;

import GYM.Client;
import GYM.Instructor;
import GYM.Message;
import GYM.Milestone;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class InstructorTrackingTest {


    public Client C1=new Client("abood", "abood@gmail.com", "1234",
            "Client", "Basic");
    public Instructor I1 =new Instructor("khader","khader@gmail.com","20304050",
            "Instructor","Gold");

    public Milestone milestone=new Milestone("90",  "26",  "7",  C1.getUserName());
    private boolean state,Send;

    @Given("the instructor clicks on the {string} button7")
    public void the_instructor_clicks_on_the_button7(String clientsTracking) {

    }

    @When("the instructor select a specific client")
    public void the_instructor_select_a_specific_client() {

    }

    @When("the instructor clicks on the {string} button8")
    public void the_instructor_clicks_on_the_button8(String clientTracking) {

        Instructor.milestones.add(milestone);
        state=I1.ClientTracking(C1.getUserName());

    }

    @Then("the system displays progress metrics.")
    public void the_system_displays_progress_metrics() {
        if (state)
            Assertions.assertTrue(true,"displays Milestones");
        else
            Assertions.fail("Error Client Tracking");

    }
    ///////////////////////////////////////////////////////////////////////////

    @Given("the instructor Send motivational reminders")
    public void the_instructor_Send_motivational_reminders() {
    }

    @When("the instructor select a client and compose a motivational message")
    public void the_instructor_select_a_client_and_compose_a_motivational_message() {


    }

    @When("the instructor clicks on the {string} button10")
    public void the_instructor_clicks_on_the_button10(String sendMotivation) {
        Send=I1.sendMessage(C1,"motivational message");

    }

    @Then("An messasge appear to clients")
    public void an_messasge_appear_to_clients() {
        if (Send)
            Assertions.assertTrue(true,"motivational message sent successfully");
        else
            Assertions.fail("Error in Send Message");
    }


}

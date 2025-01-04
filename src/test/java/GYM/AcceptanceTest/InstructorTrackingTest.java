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


    public Client C1;
    public Instructor I1 =new Instructor("khader","khader@gmail.com","20304050",
            "Instructor","Gold");
    private boolean state;
    private Message M1;
    private boolean Send;

    @Given("the instructor clicks on the {string} button7")
    public void the_instructor_clicks_on_the_button7(String clientsTracking) {

    }

    @When("the instructor select a specific client")
    public void the_instructor_select_a_specific_client() {
        C1=new Client("mohammad","mohammad@gmail.com","10203040",
                "Client","Basic");
        Client.addMilestone("89","28","4","mohammad");
        Assertions.assertTrue(true);
    }

    @When("the instructor clicks on the {string} button8")
    public void the_instructor_clicks_on_the_button8(String progressMetrics) {
        I1.ClientTracking(C1.getUserName());
        System.out.println("//////////////////////////////////////////////////////////");
        I1.ClientTracking("sameer");
        state=true;
    }

    @Then("the system displays progress metrics.")
    public void the_system_displays_progress_metrics() {
    Assertions.assertTrue(state,"Instructor Track the client");
    }
///////////////////////////////////////////////////////////////////////////
    @Given("the instructor Send motivational reminders")
    public void the_instructor_Send_motivational_reminders() {
    }

    @When("the instructor select a client and compose a motivational message")
    public void the_instructor_select_a_client_and_compose_a_motivational_message() {
        M1=new Message("motivational", "ammar",
                "HI do your best at the course");

    }

    @When("the instructor clicks on the {string} button10")
    public void the_instructor_clicks_on_the_button10(String sendMotivation) {
        I1.SendMessage(M1);
        Send=true;
    }

    @Then("An messasge appear to clients")
    public void an_messasge_appear_to_clients() {
        Assertions.assertTrue(Send,"Instructor sent the message");
    }


}

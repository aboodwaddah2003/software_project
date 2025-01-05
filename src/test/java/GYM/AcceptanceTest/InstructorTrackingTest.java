package GYM.AcceptanceTest;

import GYM.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class InstructorTrackingTest {


    public Client C1;

    public Instructor I1 =new Instructor("khader","khader@gmail.com","20304050",
            "Instructor","Gold");

    Client n1 = new Client("sead", "moh@gmail.com", "10203040", "Client", "Gold");

    private boolean state;
    private Message M1;
    private boolean Send;

    @Given("the instructor clicks on the clientsTracking")
    public void the_instructor_clicks_on_the_clients_tracking() {
        ProgramService.enrollClientInProgram(n1,"Muscle Gain Program");
        Userlist.users.add(n1);
    }
    @When("the instructor select a specific client")
    public void theInstructorSelectASpecificClient() {
        I1.addMilestone(1,"sead","78","3.2","present","30/9/2024");
    }
    @When("add the required data for the client")
    public void add_the_required_data_for_the_client() {
        state=I1.addMilestone(1,"sead","78","3.2","present","30/9/2024");
    }
    @Then("the system will add the data for specific client")
    public void the_system_will_add_the_data_for_specific_client() {
        if(state)
            Assertions.assertTrue(true);

        else
            Assertions.fail("dvdv");
    }

    ////////////////////////////////////////////////////////////////


    @When("the instructor search on specific client")
    public void the_instructor_search_on_specific_client() {
        I1.addMilestone(1,"sead","90","5","present","1/9/2024");
        I1.addMilestone(1,"sead","86","4.2","present","12/9/2024");
        I1.addMilestone(1,"sead","78","4","present","30/9/2024");
        I1.addMilestone(1,"sead","75","3.2"," not present","4/10/2024");
    }
    @When("press show activity button")
    public void press_show_activity_button() {
        state=I1.displayMilestones("sead");
    }
    @Then("the system will  the data for specific client")
    public void the_system_will_the_data_for_specific_client() {
       if(state)
           Assertions.assertTrue(true);
       else
           Assertions.fail("dvdv");
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

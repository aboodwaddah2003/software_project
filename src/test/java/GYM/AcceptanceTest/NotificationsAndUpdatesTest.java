package GYM.AcceptanceTest;

import GYM.Instructor;
import GYM.Message;
import GYM.Program;
import GYM.ProgramManagementPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class NotificationsAndUpdatesTest {
    private Instructor I1=new Instructor("mahmoud", "moh@gmail.com",
            "10203040", "Instructor", "Gold");

    private ProgramManagementPage P1=new ProgramManagementPage();

    Program P2 = new Program("Yoga", "easy", 10, 8,
            "goals","online", "yoga.jpg");

    private boolean Updated,state;

    @Given("the instructor in the programs management paage1")
    public void the_instructor_in_the_programs_management_paage1() {
    }

    @Given("the instructor make changes to a program")
    public void the_instructor_make_changes_to_a_program() {
        P1.UpdateProgram(P2);
        Updated=true;
        
    }

    @When("the instructor confirm the updates")
    public void the_instructor_confirm_the_updates() {
        Assertions.assertTrue(Updated);
    }

    @Then("the system automatically notifies all enrolled clients about the changes via their preferred notification method,and includes the updated details in the notification.")
    public void the_system_automatically_notifies_all_enrolled_clients_about_the_changes_via_their_preferred_notification_method_and_includes_the_updated_details_in_the_notification() {
        I1.notifiesAll(P2);

    }

    ///////////////////////////////////////////////////////////////////////////
    @Given("the instructor has created a new program")
    public void the_instructor_has_created_a_new_program() {
        P1.CreateNewProgram(P2);
    }

    @When("the instructor clicks on the {string} button4")
    public void the_instructor_clicks_on_the_button4(String AnnounceProgram) {
        I1.AnnounceProgram(P2);
        state=true;
    }

    @Then("the system sends a notification to all clients about the new program")
    public void the_system_sends_a_notification_to_all_clients_about_the_new_program() {
    Assertions.assertTrue(state,"sends a notification to all clients about the new program");
    }

}

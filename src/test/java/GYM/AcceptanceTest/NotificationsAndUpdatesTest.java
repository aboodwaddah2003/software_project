package GYM.AcceptanceTest;

import GYM.Client;
import GYM.Instructor;
import GYM.Program;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class NotificationsAndUpdatesTest {
    private Instructor I1=new Instructor("mahmoud", "moh@gmail.com",
            "10203040", "Instructor", "Gold");
    public Client C1=new Client("mohammad","mohammad@gmail.com","10203040",
            "Client","Basic");

    Program P2= new Program ("Flexibility Program", "Intermediate", "Flexibility", 135.50,8);


    private boolean Updated,state;

    @Given("the instructor in the programs management paage1")
    public void the_instructor_in_the_programs_management_paage1() {
    }

    @Given("the instructor make changes to a program")
    public void the_instructor_make_changes_to_a_program() {
        Updated=I1.UpdateProgram( "Flexibility Program",  "Intermediate",  "Flexibility", 135.50, 8);


    }

    @When("the instructor confirm the updates")
    public void the_instructor_confirm_the_updates() {
        if (Updated)
            Assertions.assertTrue(true,"Program Updated Successfully");
        else
            Assertions.fail("Error in Update program");
    }

    @Then("the system automatically notifies all enrolled clients about the changes via their preferred notification method,and includes the updated details in the notification.")
    public void the_system_automatically_notifies_all_enrolled_clients_about_the_changes_via_their_preferred_notification_method_and_includes_the_updated_details_in_the_notification() {
        state=I1.NotifyAll(C1,"the program"+P2.getName()+"was updated");

        if (state)
            Assertions.assertTrue(true,"Program Deleted Successfully");
        else
            Assertions.fail("Error in delete program");
    }

    ///////////////////////////////////////////////////////////////////////////
    @Given("the instructor has created a new program")
    public void the_instructor_has_created_a_new_program() {
        state=I1.CreateNewProgram(P2);

        if (state)
            Assertions.assertTrue(true,"Program created Successfully");
        else
            Assertions.fail("Error in create program");
    }

    @When("the instructor clicks on the {string} button4")
    public void the_instructor_clicks_on_the_button4(String AnnounceProgram) {
        state=I1.NotifyAll(C1,"the new program"+P2.getName()+"is available");

    }

    @Then("the system sends a notification to all clients about the new program")
    public void the_system_sends_a_notification_to_all_clients_about_the_new_program() {
        if (state)
            Assertions.assertTrue(true,"notify All Successfully");
        else
            Assertions.fail("Error in NotifyAll");
    }

}

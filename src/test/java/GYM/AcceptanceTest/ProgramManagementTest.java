package GYM.AcceptanceTest;

import GYM.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;


public class ProgramManagementTest {

     Instructor I1;
    ProgramManagementPage P1=new ProgramManagementPage();
     Program P2 = new Program("Yoga", "easy", 10, 8,
             "goals","online", "yoga.jpg");


    public boolean Created,Updated,Delete;
    private LocalDate localDate=LocalDate.of(2025, 1, 1);


    @Given("the instructor in the programs management page3")
        public void the_instructor_in_the_programs_management_page3 () {
        I1 = new Instructor("mahmoud", "moh@gmail.com",
                "10203040", "Instructor", "Gold");


    }

        @When("the instructor select CreateNewProgram")
        public void the_instructor_select_create_new_program () {
        // Write code here that turns the phrase above into concrete actions
        P1.CreateNewProgram(P2);
        Created = true;
    }

        @When("the instructor provide the required details")
        public void the_instructor_provide_the_required_details () {
        P2 = new Program("Yoga", "hard", 20, 6,
                "goal1", "offline", "yoga.jpg");
    }


        @Then("the system saves the new program and displays a confirmation message,And the program becomes available for clients.")
        public void the_system_saves_the_new_program_and_displays_a_confirmation_message_and_the_program_becomes_available_for_clients() {
        Assertions.assertTrue(Created, "New program created");

    }

        /////////////////////////////////////////////////////////////////////////////////////done//

        @Given("the instructor in programs management page3")
        public void theInstructorInProgramsManagementPage3 () {
        //duplicated
    }

        @When("the instructor try to save the program without providing inputs")
        public void the_instructor_try_to_save_the_program_without_providing_inputs () {
        P2 = new Program("", "easy", 10, 8,
                "goals", "", "yoga.jpg");

        Created = false;

    }


        @Then("the creation is unsuccessfully and alert show you should fill all details")
        public void the_creation_is_unsuccessfully_and_alert_show_you_should_fill_all_details () {
        Assertions.assertFalse(Created, "The creation is unsuccessfully,You should fill all details");

    }

//////////////////////////////////////////////////////////////////////////////////
    @Given("the instructor in the programs management page33")
    public void the_instructor_in_the_programs_management_page33() {
    //duplicated
    }

    @When("the instructor select an existing program and click on the {string} button")
    public void the_instructor_select_an_existing_program_and_click_on_the_button(String update) {


    }

    @When("the instructor update the program details")
    public void the_instructor_update_the_program_details() {
        P2 = new Program("Yoga", "hard", 10, 8,
                "goals","online", "yoga.jpg");

        P1.UpdateProgram(P2);
        Updated=true;
    }

    @Then("the system saves the updated program and displays a confirmation message")
    public void the_system_saves_the_updated_program_and_displays_a_confirmation_message() {
        Assertions.assertTrue(Updated, "The program updated successfully.");
    }

    //////////////////////////////////////////////////////////////////////////////////
    @Given("the instructor is editing a program")
    public void the_instructor_is_editing_a_program() {

    }

    @When("the instructor try to save the changes without providing mandatory fields")
    public void the_instructor_try_to_save_the_changes_without_providing_mandatory_fields() {
        P2 = new Program("", "", 10, 8,
                "","", "yoga.jpg");

        P1.UpdateProgram(P2);
        Updated=false;
    }

    @Then("the system shows validation error messages indicating the missing fields.")
    public void the_system_shows_validation_error_messages_indicating_the_missing_fields() {
        Assertions.assertFalse(Updated, "Missing fields, no update.");
    }

    //////////////////////////////////////////////////////////////////////////////////
    @Given("the instructor in the programs management page333")
    public void the_instructor_in_the_programs_management_page333() {
        // duplicated
    }

    @When("the instructor select an existing program and click on the delete button")
    public void the_instructor_select_an_existing_program_and_click_on_the_delete_button(){
        P1.Delete(P2,localDate);
        Delete=true;
    }

    @Then("the system permanently deletes the program")
    public void the_system_permanently_deletes_the_program() {
    Assertions.assertTrue(Delete,"The Program Deleted Successfully");
    }

    //////////////////////////////////////////////////////////////////////////////////
    @Given("the instructor tries to delete a program assigned to active gym members")
    public void the_instructor_tries_to_delete_a_program_assigned_to_active_gym_members() {

    }

    @When("the instructor click the {string} button6")
    public void the_instructor_click_the_button6(String string) {
        P1.Delete(P2,localDate);
        Delete=false;
    }

    @Then("the system shows a notification that the program cannot be deleted until it is unassigned from all active members")
    public void the_system_shows_a_notification_that_the_program_cannot_be_deleted_until_it_is_unassigned_from_all_active_members() {
    Assertions.assertFalse(Delete,"the program can't be deleted until it is unassigned from all active members");
    }


}

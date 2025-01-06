package GYM.AcceptanceTest;

import GYM.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;


public class ProgramManagementTest {

    Instructor I1=new Instructor("userName",  "email",
            "password",  "type", "subscriptionPlan");
    Program P3,P2 = new Program("season", "hard","hands", 30, 4);


    public boolean Created,Updated,Delete;
    private LocalDate StartDate =LocalDate.of(2025, 1, 1);
    private LocalDate fakeDate;


    @Given("the instructor in the programs management page3")
    public void the_instructor_in_the_programs_management_page3 () {


    }

    @When("the instructor select CreateNewProgram")
    public void the_instructor_select_create_new_program () {
        // Write code here that turns the phrase above into concrete actions
        Created=I1.CreateNewProgram(P2);

    }


    @Then("the system saves the new program and displays a confirmation message," +
            "And the program becomes available for clients.")
    public void the_system_saves_the_new_program_and_displays_a_confirmation_message_and_the_program_becomes_available_for_clients() {
        if (Created)
            Assertions.assertTrue(true,"Program Created");
        else
            Assertions.fail("Program does not Created");

    }

    /////////////////////////////////////////////////////////////////////////////////////done//

    @Given("the instructor in programs management page3")
    public void theInstructorInProgramsManagementPage3 () {
        //duplicated
    }

    @When("the instructor try to save the program without providing inputs")
    public void the_instructor_try_to_save_the_program_without_providing_inputs () {
        P2 = new Program("", "hard","", 0, 0);
        Created=I1.CreateNewProgram(P2);

    }


    @Then("the creation is unsuccessfully and alert show you should fill all details")
    public void the_creation_is_unsuccessfully_and_alert_show_you_should_fill_all_details () {
        if (!Created)
            Assertions.assertFalse(Created,"Program Created");
        else
            Assertions.fail("Program does not Created");

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
        Updated=I1.UpdateProgram("season", "hard","hands", 30, 4);

    }

    @Then("the system saves the updated program and displays a confirmation message")
    public void the_system_saves_the_updated_program_and_displays_a_confirmation_message() {
        if (Updated)
            Assertions.assertTrue(true,"Program Updated");
        else
            Assertions.fail("Error in updated program");
    }

    //////////////////////////////////////////////////////////////////////////////////
    @Given("the instructor is editing a program")
    public void the_instructor_is_editing_a_program() {

    }

    @When("the instructor try to save the changes without providing mandatory fields")
    public void the_instructor_try_to_save_the_changes_without_providing_mandatory_fields() {
        P2 = new Program("", "","", 10, 8 );

        Updated=I1.UpdateProgram("",  "",  "focusArea", 10, 4);

    }

    @Then("the system shows validation error messages indicating the missing fields.")
    public void the_system_shows_validation_error_messages_indicating_the_missing_fields() {
        if (!Updated)
            Assertions.assertFalse(false,"Program Created");
        else
            Assertions.fail("Error in updated program");
    }

    //////////////////////////////////////////////////////////////////////////////////
    @Given("the instructor in the programs management page333")
    public void the_instructor_in_the_programs_management_page333() {
        // duplicated
    }

    @When("the instructor select an existing program and click on the delete button")
    public void the_instructor_select_an_existing_program_and_click_on_the_delete_button(){
        P3= new Program ("Weight Loss Program", "Beginner", "Weight loss", 120,6);
        P3.setStartDate(StartDate);
        fakeDate=LocalDate.of(2025,3,20);
        Delete=I1.Delete(P3,fakeDate);

    }

    @Then("the system permanently deletes the program")
    public void the_system_permanently_deletes_the_program() {
        if (Delete)
            Assertions.assertTrue(true,"Program Deleted Successfully");
        else
            Assertions.fail("Error in delete program");

    }

    //////////////////////////////////////////////////////////////////////////////////
    @Given("the instructor tries to delete a program not complete")
    public void the_instructor_tries_to_delete_a_program_not_complete() {

    }

    @When("the instructor click the {string} button6")
    public void the_instructor_click_the_button6(String string) {
        P3= new Program ("to delete", "hard","hands", 30, 4);
        P3.setStartDate(StartDate);
        fakeDate=LocalDate.of(2025,1,25);
        Delete=I1.Delete(P3,fakeDate);
    }

    @Then("the system shows a notification that the program cannot be deleted until it is unassigned from all active members")
    public void the_system_shows_a_notification_that_the_program_cannot_be_deleted_until_it_is_unassigned_from_all_active_members() {
        if (!Delete)
            Assertions.assertFalse(false,"Program does not deleted");
        else
            Assertions.fail("Error at delete program");
    }


}

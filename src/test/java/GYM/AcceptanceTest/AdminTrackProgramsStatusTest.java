package GYM.AcceptanceTest;

import GYM.Admin;
import GYM.ProgramService;
import org.junit.jupiter.api.Assertions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.time.LocalDate;

public class AdminTrackProgramsStatusTest {
    public ProgramService P ;
    public Admin A1;
    public boolean state;
    LocalDate localDate;
    @Given("the admin is logged into the system")
    public void the_admin_is_logged_into_the_system() {

        A1 = new Admin("abood", "abood@gmail.com", "ab12345678", "Admin", "Owner");
        P=new ProgramService();
        P.fillDataProgram();

        localDate=LocalDate.of(2025,1,15);
    }

    @When("the admin navigates to the Programs section")
    public void the_admin_navigates_to_the_programs_section() {

    }

    @When("the admin selects Active Programs")
    public void the_admin_selects_active_programs() {
        state = A1.countActivePrograms(localDate);
        if (state) {
            Assertions.assertTrue(state);
        } else {
            Assertions.fail("No active programs available");
        }
    }

    @Then("the system displays a list of all active programs with details")
    public void the_system_displays_a_list_of_all_active_programs_with_details() {

        A1.showActivePrograms(localDate);
    }

    @When("the admin selects Completed Programs")
    public void the_admin_selects_completed_programs() {
        state=A1.countActivePrograms(localDate);
        if (state) {
            Assertions.assertTrue(state);
        } else {
            Assertions.fail("No completed programs ");
        }

    }
    @Then("the system displays a list of all completed programs")
    public void the_system_displays_a_list_of_all_completed_programs() {
        A1.showCompletedPrograms(localDate);
    }
}
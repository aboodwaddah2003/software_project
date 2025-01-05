package GYM.AcceptanceTest;
import GYM.Admin;
import GYM.Client;
import GYM.ProgramService;
import GYM.Userlist;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class ProgramStatsAndReportsTest {

public ProgramService p;
public Userlist u=new Userlist();
public boolean state;
public Admin A1;


    @Given("the admin is logged into the dashboard")
    public void the_admin_is_logged_into_the_dashboard() {
   p=new ProgramService();
   u.fillDataClientEnrollInProgram();
   A1=new Admin("abood","abood@gmail.com","ab12345678","Admin","Owner");
        Client n1 = new Client("sead", "moh@gmail.com", "10203040", "Client", "Gold");
      ProgramService.fillData4();
    }
    @When("the admin navigates to the Program Statistics section")
    public void the_admin_navigates_to_the_program_statistics_section() {
state=A1.showProgramsStatistics();
if(state)
    Assert.assertTrue(state);
else
    Assertions.fail("there is no client enroll in any programs");
    }
    @Then("the system displays a list of programs sorted by enrollment count")
    public void the_system_displays_a_list_of_programs_sorted_by_enrollment_count() {

    }

    @When("the admin navigates to the Reports section")
    public void the_admin_navigates_to_the_reports_section() {
        if(A1.calculateTotalRevenue()!=0)
            state=true;
    }
    @When("selects Revenue Reports")
    public void selects_revenue_reports() {

          if(state)
              Assertions.assertTrue(state);
      else
          Assertions.fail(" The Revenue amount is zero  ");

    }
    @Then("the system calculates the total revenue and display it")
    public void the_system_calculates_the_total_revenue_and_display_it() {
A1.generateRevenueReport();
    }


    @When("the admin navigates to the Reports section then enter the name of client")
    public void the_admin_navigates_to_the_reports_section_then_enter_the_name_of_client() {

    }
    @When("selects attendance Reports")
    public void selects_attendance_reports() {
        A1.printAttendancePercentage("sead",1);
    }
    @Then("the system view the attendance Reports")
    public void the_system_view_the_attendance_reports() {

    }

}

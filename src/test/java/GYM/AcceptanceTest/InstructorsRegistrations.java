package GYM.AcceptanceTest;

import GYM.Admin;
import GYM.ManageAccountHelper;
import GYM.Userlist;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class InstructorsRegistrations {
    ManageAccountHelper ManageAccount;
    public  Admin A2;
   public boolean state;
    @Given("the admin is on the instructor registration requests page")
    public void the_admin_is_on_the_instructor_registration_requests_page() {
        ManageAccountHelper.fillData2();
        Userlist.fillData();
       A2=new Admin("abd21","abd21@gmail.com","12121212","Admin","");
    }
    @When("the admin selects a pending instructor registration request from the list")
    public void the_admin_selects_a_pending_instructor_registration_request_from_the_list() {
       state=A2.approveNewInstructor("mohammedK");
    }
    @When("clicks the approve button for the selected request")
    public void clicks_the_approve_button_for_the_selected_request() {
        if(state)
        {
            Assertions.assertTrue(true);
        }
        else
            Assert.fail("dvdv");
    }
    @Then("the system updates the instructor's status to Approved and adds him")
    public void the_system_updates_the_instructor_s_status_to_approved_and_adds_him() {
       System.out.println("new instructor add the system successfully");
    }

    @When("clicks the approve button1 for the selected request")
    public void clicks_the_approve_button1_for_the_selected_request() {
      state=A2.approveNewInstructor("mahmoud");
        if(!state)
        {
            Assertions.assertFalse(state);
        }
        else
            Assert.fail("dvdv");
    }
    @Then("alert show this username is already registered approval not possible")
    public void alert_show_this_username_is_already_registered_approval_not_possible() {
System.out.println("this username is already registered approval not possible");
    }


}

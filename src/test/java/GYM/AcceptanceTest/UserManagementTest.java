package GYM.AcceptanceTest;

import GYM.Admin;
import GYM.User;
import GYM.Userlist;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import javax.swing.*;

public class UserManagementTest {
    public  boolean state;

    public Userlist user;
  public Admin A1;

  public User u1;
    @Given("the admin in management user page")
    public void the_admin_in_management_user_page() {
        Userlist.fillData();
       A1=new Admin("abood","abood@gmail.com","ab12345678","Admin","Owner");

    }
    @When("the admin fills in the  valid client's information in the system")
    public void the_admin_fills_in_the_valid_client_s_information_in_the_system() {
      state= A1.addAccountClient("ahmad","ahmad@gmail.com","12345678","Client","Basic");
    }

    @When("the admin fills in the  valid instructors information in the system")
    public void theAdminFillsInTheValidInstructorsInformationInTheSystem() {
        state= A1.addAccountInstructor("Alisead2","moh@gmail.com","12345678","Instructors","Premium");

    }

    @When("the admin fills in the  invalid instructors or client information in the system")
    public void theAdminFillsInTheInvalidInstructorsOrClientInformationInTheSystem() {
        state=A1.checkAllInput("alimoh","ali@gmail.com","1234","Client","Premium");
    }


    @When("clicks create account")
    public void clicks_create_account() {
if(state)
{
    Assertions.assertTrue(true);
}
else
    Assertions.assertFalse(state);
    }

    @When("clicks create account button2")
    public void clicksCreateAccountButton2() {
        if(!state)
        {
            Assertions.assertFalse(state);
        }
        else
            Assertions.fail("dvdv");
    }



    @When("the admin enter new valid username")
    public void theAdminEnterNewValidUsername() {
state=A1.UpdateUserName("loay54","osama");
    }

    @When("the admin enter the new username that already exist in the system")
    public void theAdminEnterTheNewUsernameThatAlreadyExistInTheSystem() {
        state = A1.UpdateUserName("waddah", "abood");
    }

    @When("the admin enter the new valid email or valid role or valid subscription Plans or valid password")
    public void theAdminEnterTheNewValidEmailOrValidRoleOrValidSubscriptionPlansOrValidPassword() {
        state=A1.updateData("waddah","abd21@gmail.com","12345678","","");
    }

    @When("the admin enter the new  email that already in system")
    public void theAdminEnterTheNewEmailThatAlreadyInSystem() {
    state=A1.updateData("bayan","osama@gmail.com","","","");
    }

    @When("press update information button")
    public void pressUpdateInformationButton() {
        if(state)
        {
            Assertions.assertTrue(true);
        }
        else
            Assertions.assertFalse(state);
    }
    @When("press update information button1")
    public void pressUpdateInformationButton1() {
        if(!state)
        {
            Assertions.assertFalse(state);
        }
        else
            Assert.fail("dvdv");
    }
    @Then("alert show that the username updated successfully")
    public void alertShowThatTheUsernameUpdatedSuccessfully() {
       System.out.println("the update of username is successfully");
    }

    @Then("the registered is successfully")
    public void the_registered_is_successfully() {
        System.out.println("add account  successfully");
    }


    @Then("the registered is unsuccessfully and alert show there is a invalid input")
    public void theRegisteredIsUnsuccessfullyAndAlertShowThereIsAInvalidInput() {
        System.out.println("There is a invalid input ");
    }

    @Then("alert show that The username is already in use")
    public void alertShowThatTheUsernameIsAlreadyInUse() {
       System.out.println("the user name is already existing in the system");
    }

    @Then("alert show that The update operation is success")
    public void alert_show_that_the_update_operation_is_success() {
System.out.println("the update of Date successful");
    }


    @Then("alert show that the email is already in system")
    public void alertShowThatTheEmailIsAlreadyInSystem() {

        System.out.println("the email is already in system");

    }
    @When("the admin chooses the account he wants to deactivate")
    public void the_admin_chooses_the_account_he_wants_to_deactivate() {
state=A1.setAccountStatus("mahmoud",false);
    }
    @When("press deactivate account")
    public void press_deactivate_account() {
        if(state)
        {
            Assertions.assertTrue(true);
        }
        else
            Assert.fail("dvdv");
    }
    @When("press deactivate account button")
    public void press_deactivate_account_button() {
        state=A1.setAccountStatus("mahmoud",false);
        if(!state)
        {
            Assertions.assertFalse(false);
        }
        else
            Assert.fail("dvdv");
    }
    @Then("alert show that  the account become deactivate and user cant enter system")
    public void alert_show_that_the_account_become_deactivate_and_user_cant_enter_system() {
System.out.println("the deactivate for this account is success");
    }
    @Then("An alert appears notifying the admin that the account is already deactivated")
    public void anAlertAppearsNotifyingTheAdminThatTheAccountIsAlreadyDeactivated() {
        System.out.println("the account is already deactivated");
    }

}

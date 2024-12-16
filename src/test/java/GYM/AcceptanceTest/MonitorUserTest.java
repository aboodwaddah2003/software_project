package GYM.AcceptanceTest;

import GYM.Admin;
import GYM.ManageAccountHelper;
import GYM.User;
import GYM.Userlist;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class MonitorUserTest {

    public boolean state;
    public  Admin A1;
    public  ManageAccountHelper m=new ManageAccountHelper();
    @Given("the admin logs into the dashboard")
    public void the_admin_logs_into_the_dashboard()
    {
      Userlist.fillData3();
        A1=new Admin("abood","abood@gmail.com","ab12345678","Admin","Owner");
        m.fillRecordActivity();
    }
    @When("the admin go to  displays a user activity panel")
    public void the_admin_go_to_displays_a_user_activity_panel()
    {
state= m.fetchUserActivityPanel();
if(state)
{
    Assertions.assertTrue(true);

}
else
    Assert.fail("dvdv");
    }
    @Then("The panel shows key statistics such as the number of active users, number of login to the system")
    public void thePanelShowsKeyStatisticsSuchAsTheNumberOfActiveUsersNumberOfLoginToTheSystem()
    {
       A1.printLoginRecords();
    }



    @When("chose the user he wants")
    public void chose_the_user_he_wants() {
        String userName = "alaa22";
        state = A1.ShowUserAction(userName);
        if (state) {
            Assertions.assertTrue(true);
        } else {
            Assertions.fail("The user " + userName + " did not perform any actions.");
        }
    }
    @Then("the actions performed by the user will be displayed")
    public void the_actions_performed_by_the_user_will_be_displayed() {

    }

    @When("chose the date {string} he wants")
    public void chose_the_date_he_wants(String date) {
        state = A1.ShowDateAction(date);
        if (state) {
            Assertions.assertTrue(true);
        } else {
            Assertions.fail("No actions were found for the date: " + date);
        }
    }

    @When("chose the invalid date {string}")
    public void chose_the_invalid_date(String string) {
state=A1.ShowDateAction(string);

if(!state)
    Assert.assertFalse(state);

else
    Assert.fail("DVDV");
    }


    @Then("all actions that occurred on that specific date will be appear")
    public void all_actions_that_occurred_on_that_specific_date_will_be_appear() {

    }


    @Then("alert show the user is invalid")
    public void alert_show_the_user_is_invalid() {
        System.out.println("The date is invalid ");
    }

}

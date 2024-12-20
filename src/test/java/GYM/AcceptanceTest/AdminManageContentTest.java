package GYM.AcceptanceTest;

import GYM.Admin;
import GYM.Client;
import GYM.ContentMangerService;
import GYM.Instructor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class AdminManageContentTest {
    ContentMangerService contentManger;
    Admin A1 ;
    Instructor c1;

    boolean state;
    static boolean flag = false;
    public  Client u1;
    @Given("the admin navigates to the Pending Submissions section")
    public void the_admin_navigates_to_the_pending_submissions_section() {
     A1 = new Admin("abood", "abood@gmail.com", "ab12345678", "Admin", "Owner");
    contentManger=new ContentMangerService();
     c1=new Instructor("mahmoud", "moh@gmail.com", "10203040", "Instructor", "");
         u1=new Client("waddah", "waddah@gmail.com", "1234", "Instructor", "Prime");

    }
    @When("the admin selects a wellness submitted by an instructor")
    public void the_admin_selects_a_wellness_submitted_by_an_instructor()
    {
        if(!flag) {
            c1.addContent("10 Healthy Recipes", "John Doe", "pending", "12/10/2024", "You should eat egg and don't eat meat.");
            c1.addContent("Fitness Tips", "Jane Smith", "pending", "12/12/2024", "Morning walks and stretching help you stay active.");
            contentManger.showAllContent();
            flag=true;
        }
    }
    @When("select the {string} form the wellness that want to approved")
    public void select_the_form_the_wellness_that_want_to_approved(String string)
    {
     state=A1.updateContentStatus(string,"approve");
     if(state)
         Assertions.assertTrue(state);
     else
         Assertions.fail("No content");
    }

    @When("select the {string} form the wellness that want to rejected")
    public void select_the_form_the_wellness_that_want_to_rejected(String string) {
        state=A1.updateContentStatus(string,"rejected");
        if(state)
            Assertions.assertTrue(state);
        else
            Assertions.fail("No content");
    }

    @When("the admin selects a wellness or tips submitted by user")
    public void the_admin_selects_a_wellness_or_tips_submitted_by_user() {
        u1.addContent("Strength Training Basics", "Sarah Wilson", "pending", "12/20/2024","Strength training improves muscle health and boosts metabolism.");

    }
    @When("select the {string} form the wellness or tips that want to approved")
    public void select_the_form_the_wellness_or_tips_that_want_to_approved(String string) {
        state=A1.updateContentStatus(string,"approve");
        if(state)
            Assertions.assertTrue(state);
        else
            Assertions.fail("No content");
    }

    @Then("the system updates the article status to Approved")
    public void the_system_updates_the_article_status_to_approved() {
        System.out.println("this is approved contents");
  contentManger.showApprovedContent();
    }

    @Then("the system updates the article status to rejected")
    public void the_system_updates_the_article_status_to_rejected() {
        System.out.println("this is rejected contents");
        contentManger.showRejectedContent();
    }

    @Given("the admin navigates to the {string} section")
    public void theAdminNavigatesToTheSection(String string) {

    }
    @When("the admin selects a user complaint")
    public void theAdminSelectsAUserComplaint() {

    }
    @When("reviews the details of the complaint")
    public void reviewsTheDetailsOfTheComplaint() {

    }
    @Then("the admin can respond with a solution or clarification then updates the status of the complaint to {string}")
    public void theAdminCanRespondWithASolutionOrClarificationThenUpdatesTheStatusOfTheComplaintTo(String string) {

    }

}

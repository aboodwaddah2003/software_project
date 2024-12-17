package GYM.AcceptanceTest;

import GYM.Admin;
import GYM.ContentManger;
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
    @Given("the admin navigates to the Pending Submissions section")
    public void the_admin_navigates_to_the_pending_submissions_section() {
     A1 = new Admin("abood", "abood@gmail.com", "ab12345678", "Admin", "Owner");
    contentManger=new ContentMangerService();
     c1=new Instructor("mahmoud", "moh@gmail.com", "10203040", "Instructor", "");

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

    @When("select the {string} form the wellness that want to rejects")
    public void select_the_form_the_wellness_that_want_to_rejects(String string) {
        state=A1.updateContentStatus(string,"rejected");
        if(state)
            Assertions.assertTrue(state);
        else
            Assertions.fail("No content");
    }


    @Then("the system updates the article status to Approved")
    public void the_system_updates_the_article_status_to_approved() {
        System.out.println("this is approved contents");
  contentManger.showApprovedContent();
        System.out.println("this is rejected contents");
  contentManger.showRejectedContent();
    }


}

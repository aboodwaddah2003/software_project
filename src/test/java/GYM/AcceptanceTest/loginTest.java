package GYM.AcceptanceTest;

import GYM.User;
import GYM.Userlist;
import GYM.loginHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class loginTest {
    public loginHelper login;

    public boolean state;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Userlist.fillData();
        login = new loginHelper();


    }

    @When("the user enters a valid username {string} and a valid password {string}")
    public void the_user_enters_a_valid_username_and_a_valid_password(String string, String string2) {
        state = login.UserPassTrue(string, string2);

    }

    @When("presses the login button")
    public void presses_the_login_button()
    {
        if (state)
        {
            Assertions.assertTrue(true);
        }
        else
            Assertions.fail("dvdvdv");
    }



    @Then("the user is successfully logged into the system")
    public void the_user_is_successfully_logged_into_the_system() {

      System.out.println(login.getMessage());
    }
}

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
    public String userName;
    public String password;
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Userlist.fillData();
        login = new loginHelper();


    }

    @When("the user enters a valid username {string} and a valid password {string}")
    public void the_user_enters_a_valid_username_and_a_valid_password(String string, String string2) {
        userName=string;
        password=string2;

    }

    @When("presses the login button")
    public void presses_the_login_button()
    {
        state = login.UserPass(userName, password);
    }



    @Then("the user is successfully logged into the system")
    public void the_user_is_successfully_logged_into_the_system() {
        if (state)
        {
            Assertions.assertTrue(true);
        }
        else
            Assertions.fail("dvdvdv");
      System.out.println(login.getMessage());
    }

/////////////////////////s2

  /*  @Given("when the user in the login page")
    public void when_the_user_in_the_login_page() {

        Userlist.fillData();
        login=new loginHelper();
    }
    */

    @When("the user enters  invalid username {string}")
    public void the_user_enters_invalid_username(String string) {
       state=login.UserPass(string,"any thing");
    }
    @When("press the login button")
    public void press_the_login_button() {
        if (!state)
        {
            Assertions.assertTrue(true);
        }
        else
            Assertions.fail("dvdvdv");
    }
    @Then("the login attempt fails with an error username message")
    public void the_login_attempt_fails_with_an_error_username_message() {
        System.out.println(login.getMessage());
    }


}




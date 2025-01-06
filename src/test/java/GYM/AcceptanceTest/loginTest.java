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
        System.out.println("invalid username");
    }

    @When("the user enters an invalid password {string}")
    public void the_user_enters_an_invalid_password(String string) {
      state=login.UserPass("osama","1212");
    }
    @When("clicks the login button3")
    public void clicks_the_login_button3() {
        if (!state)
        {
            Assertions.assertTrue(true);
        }
        else
            Assertions.fail("dvdvdv");

    }
    @Then("the login attempt fails with an error pass message")
    public void the_login_attempt_fails_with_an_error_pass_message() {
        System.out.println("invalid password");
    }

    @When("the user leaves the username field empty and enters a password \"password1\"or empty pass with valid username\"osama\"")
    public void the_user_leaves_the_username_field_empty_and_enters_a_password_password1_or_empty_pass_with_valid_username_osama() {

        state=login.allFieldsAreFilled("abood","");

        boolean state1 = login.allFieldsAreFilled("", "password1");
        assert state1 == false : "Expected false when username is empty";


        boolean state2 = login.allFieldsAreFilled("osama", "");
        assert state2 == false : "Expected false when password is empty";


        boolean state3 = login.allFieldsAreFilled("123", "123");
        assert state3 == true : "Expected true when both fields are filled";


        boolean state4 = login.allFieldsAreFilled(" ", " ");
        assert state4 == false : "Expected false when both fields contain spaces only";
    }
    @When("clicks the login button4")
    public void clicks_the_login_button4() {
        if(state){
            Assertions.fail("the pass or username are empty..!");
        }
        else {
            Assertions.assertFalse(state);
        }

    }
    @Then("the login attempt fails with an error message for missing username")
    public void the_login_attempt_fails_with_an_error_message_for_missing_username() {
        System.out.println("the username or password is missing");
    }


}
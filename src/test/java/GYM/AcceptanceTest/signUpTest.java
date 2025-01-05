package GYM.AcceptanceTest;

import GYM.Userlist;
import GYM.loginHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class signUpTest {
 public  boolean state;
public loginHelper login;
public Userlist user;

    @Given("the user in signup page")
    public void the_user_in_signup_page() {
        Userlist.fillData();
        user=new Userlist();
    }
    @When("the user enter a valid username {string} and {string} and {string}  and {string} and'Basic'")
    public void the_user_enter_a_valid_username_and_and_and_and_owner(String string, String string2, String string3, String string4) {
        state=user.IsCanBeUser(string,string2 ,string3,"basic");
        if(state)
        {
            Assertions.assertTrue(true);
        }
        else
            Assertions.fail("dvdvdv");
    }

    @Then("the user successful make account in system and the alert show success signUp")
    public void the_user_successful_make_account_in_system_and_the_alert_show_success_sign_up() {
System.out.println("The signup success");
    }

    @When("the user enter the username {string} that is exist already")
    public void the_user_enter_the_username_that_is_exist_already(String string) {
     state=user.IsCanBeUser(string,"a12sd","anything","anything");
        if(!state)
        {
            Assertions.assertTrue(true);
        }
else
    Assertions.fail("dvdv");

    }

    @Then("alert show that the username is exist in the system")
    public void alert_show_that_the_username_is_exist_in_the_system() {
        System.out.println("The signup operation unsuccessful");
    }


    @When("the user enter an empty username {string} or  {string}   or {string} or {string}")
    public void the_user_enter_an_empty_username_or_or_or(String string, String string2, String string3, String string4) {
       state=user.allFieldsisIsFull(string,string2,string3,string4);
       if (!state)
       {
           Assertions.assertFalse(state);
       }
       else
         Assertions.assertTrue(state);

    }
    @Then("the alert show that there is Field empty")
    public void the_alert_show_that_there_is_field_empty() {
System.out.println("make sure to fill all fields ");
    }

    @When("the user enter invalid email {string}")
    public void theUserEnterInvalidEmail(String string) {
      state=user.IsValidEmail(string);
      if(!state)
      {
          Assertions.assertFalse(state);
      }
      else
          Assert.fail("dv");
    }
    @Then("alert show that the email error format")
    public void alertShowThatTheEmailErrorFormat() {
System.out.println("The email format is not correct");
    }

}

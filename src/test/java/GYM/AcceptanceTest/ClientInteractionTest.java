package GYM.AcceptanceTest;


import GYM.Instructor;
import GYM.Message;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class ClientInteractionTest {


    Instructor I1 =new Instructor("mohammad","mohammad1@gmail.com","30405060",
            "Instructor","Gold") ;
    public Message M3,M2, M1=new Message("message","mahmoud",  "How are you today?");
    public boolean Send;

    @Given("the instructor select one enrolled client and compose a message")
    public void the_instructor_select_one_enrolled_client_and_compose_a_message() {

    }

    @When("the instructor clicks on the {string} bottonn")
    public void the_instructor_clicks_on_the_bottonn(String send) {
    I1.SendMessage(M1);
    Send=true;
    }

    @Then("a message arrive to the buyers")
    public void a_message_arrive_to_the_buyers() {
        Assertions.assertTrue(Send,"the message arrived");
    }
////////////////////////////////////////////////////////////////////////////////////
    @Given("the instructor select one enrolled client and did not write the message")
    public void theInstructorSelectOneEnrolledClientAndDidNotWriteTheMessage() {

    }
    @When("the instructor clicks on the {string} bottonnn")
    public void the_instructor_clicks_on_the_bottonnn(String send) {
        M2=new Message("message","mahmoud",  "");
        I1.SendMessage(M2);
        Send=false;
    }
    @Then("a message did not arrive to the buyers")
    public void aMessageDidNotArriveToTheBuyers() {
        Assertions.assertFalse(Send,"the message did not arrive (Please Write a message)");
    }
    //////////////////////////////////////////////////////////////////////

    @Given("the instructor want to provide a feedback")
    public void the_instructor_want_to_provide_a_feedback() {

    }

    @When("the instructor write a message and clicks on {string} button2")
    public void the_instructor_write_a_message_and_clicks_on_button2(String sendFeedback) {
        M3=new Message("feedback", "osama",
                "HI How do you see the yoga program?");
        I1.SendMessage(M3);
        Send=true;
    }

    @Then("the system sends the feedback to the client")
    public void the_system_sends_the_feedback_to_the_client() {
        Assertions.assertTrue(Send,"the message arrived");
    }


}

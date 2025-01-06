package GYM.AcceptanceTest;


import GYM.Client;
import GYM.Instructor;
import GYM.Message;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class ClientInteractionTest {


    Instructor I1 =new Instructor("mohammad","mohammad1@gmail.com","30405060",
            "Instructor","Gold") ;
    public Client C1=new Client("userName", "default_email@example.com",
            "default_password", "Client", "Basic");
    public boolean Send;

    @Given("the instructor select one enrolled client and compose a message")
    public void the_instructor_select_one_enrolled_client_and_compose_a_message() {

    }

    @When("the instructor clicks on the {string} bottonn")
    public void the_instructor_clicks_on_the_bottonn(String send) {
        Send=I1.sendMessage(C1,"Hello");//exp =true

    }

    @Then("a message arrive to the buyers")
    public void a_message_arrive_to_the_buyers() {

        if (Send){
            Assertions.assertTrue(Send,"**The message arrived to the Client**");
            System.out.println("Message arrived to the Client");
        }
        else
            Assertions.fail("Error");
    }
    ////////////////////////////////////////////////////////////////////////////////////
    @Given("the instructor select one enrolled client and did not write the message")
    public void theInstructorSelectOneEnrolledClientAndDidNotWriteTheMessage() {

    }
    @When("the instructor clicks on the {string} bottonnn")
    public void the_instructor_clicks_on_the_bottonnn(String send) {
        Send=I1.sendMessage(C1,"");//exp=false

    }
    @Then("a message did not arrive to the buyers")
    public void aMessageDidNotArriveToTheBuyers() {
        if (!Send) {
            Assertions.assertFalse(false, "The message can't be empty");
            System.out.println("Message does not arrived,you did not write the message");
        } else {
            Assertions.fail("Error...");
        }
    }

}

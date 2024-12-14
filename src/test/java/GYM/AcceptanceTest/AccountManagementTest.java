package GYM.AcceptanceTest;

import GYM.AccountHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class AccountManagementTest {

    public AccountHelper accountHelper;
    public boolean state;


    // Scenario 1: Client is on the profile creation page
    @Given("the client is on the profile creation page")
    public void theClientIsOnTheProfileCreationPage() {
        System.out.println("Client is on the profile creation page.");
        accountHelper = new AccountHelper();
    }


    // Scenario 2: Client enters valid personal details
    @When("the client enters valid personal details")
    public void theClientEntersValidPersonalDetails(DataTable table) {
        List<List<String>> data = table.asLists(String.class);

        for (List<String> row : data) {
            if (row.size() == 3) {
                String name = row.get(0);
                String age = row.get(1);
                String goals = row.get(2);


                if (name == null || name.isEmpty() || age == null || age.isEmpty() || goals == null || goals.isEmpty()) {
                    System.out.println("Error: All fields are required.");
                    state = false;
                    return;
                }
                state = accountHelper.createProfile(name, age, goals);
            } else {
                System.out.println("Error: Missing data in the row.");
                state = false;
            }
        }
    }


    // Scenario 3: Profile created successfully
    @Then("the system successfully saves the client's profile")
    public void theSystemSuccessfullySavesTheClientsProfile() {
        Assertions.assertTrue(state, "Profile created successfully.");
    }


    // Scenario 4: Confirmation message displayed
    @And("shows a confirmation message {string}")
    public void showsAConfirmationMessage(String message) {
        System.out.println(message);
        Assertions.assertTrue(state, "Confirmation message should be displayed.");
    }


    // Scenario 5: Client has existing profiles
    @Given("the client has existing profiles")
    public void theClientHasExistingProfiles() {
        accountHelper = new AccountHelper();
        accountHelper.createProfile("Ammar", "25", "Weight Loss");
        accountHelper.createProfile("Mohamed", "30", "Muscle Gain");
    }


    // Scenario 6: Client updates dietary preferences
    @When("the client updates dietary preferences")
    public void theClientUpdatesDietaryPreferences(DataTable table) {
        List<String> preferencesList = table.asList(String.class);

        for (String preferences : preferencesList) {
            if (preferences == null || preferences.isEmpty()) {
                System.out.println("Error: Dietary preferences are required.");
                state = false;
                return;
            }
            state = accountHelper.updateDietaryPreferences("Ammar", preferences);
        }
    }


    // Scenario 7: System saves the updates
    @Then("the system saves the updates")
    public void theSystemSavesTheUpdates() {
        Assertions.assertTrue(state, "Preferences updated successfully.");
    }


    // Scenario 8: Client leaves the age field empty
    @When("the client leaves the age field empty")
    public void theClientLeavesTheAgeFieldEmpty(DataTable table) {
        List<List<String>> goalsList = table.asLists(String.class);

        for (List<String> row : goalsList) {
            String name = row.get(0);
            String age = "";
            String goals = row.get(1);


            if (name == null || name.isEmpty() || goals == null || goals.isEmpty()) {
                System.out.println("Error: Name and goals are required.");
                state = false;
                return;
            }
            state = accountHelper.createProfile(name, age, goals);
        }
    }


    // Scenario 9: System shows an error message
    @Then("the system shows an error message {string}")
    public void theSystemShowsAnErrorMessage(String message) {
        Assertions.assertFalse(state, message);
    }


    // Scenario 10: Client leaves any field empty
    @When("the client leaves any required field empty")
    public void theClientLeavesAnyRequiredFieldEmpty(DataTable table) {
        List<List<String>> data = table.asLists(String.class);

        for (List<String> row : data) {
            String name = row.get(0);
            String age = row.get(1);
            String goals = row.get(2);


            if (name == null || name.isEmpty() || age == null || age.isEmpty() || goals == null || goals.isEmpty()) {
                System.out.println("Error: All fields are required.");
                state = false;
                return;
            }
            state = accountHelper.createProfile(name, age, goals);
        }
    }


    // General step: Displays a message
    @Then("displays a message {string}")
    public void displaysAMessage(String message) {
        System.out.println(message);
        Assertions.assertTrue(message.contains("Preferences updated successfully"), "The confirmation message should contain the expected text.");
    }
}

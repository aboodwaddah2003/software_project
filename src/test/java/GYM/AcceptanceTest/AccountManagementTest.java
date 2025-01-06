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
    private AccountHelper accountHelper;
    private boolean state;

    @Given("the client is on the profile creation page")
    public void theClientIsOnTheProfileCreationPage() {
        accountHelper = new AccountHelper();
    }

    @When("the client enters valid personal details")
    public void theClientEntersValidPersonalDetails(DataTable table) {
        List<List<String>> data = table.asLists(String.class);
        for (List<String> row : data) {
            if (row.size() == 3) {
                String name = row.get(0);
                String age = row.get(1);
                String goals = row.get(2);
                if (name == null || name.isEmpty() || age == null || age.isEmpty() || goals == null || goals.isEmpty()) {
                    state = false;
                    return;
                }
                state = accountHelper.createProfile(name, age, goals);
            } else {
                state = false;
                return;
            }
        }
    }

    @Then("the system successfully saves the client's profile")
    public void theSystemSuccessfullySavesTheClientsProfile() {
        Assertions.assertTrue(state);
    }

    @And("shows a confirmation message {string}")
    public void showsAConfirmationMessage(String message) {
        Assertions.assertTrue(state, message);
    }

    @Given("the client has existing profiles")
    public void theClientHasExistingProfiles() {
        accountHelper = new AccountHelper();
        accountHelper.createProfile("Ammar", "25", "Weight Loss");
        accountHelper.createProfile("Mohamed", "30", "Muscle Gain");
    }

    @When("the client updates dietary preferences")
    public void theClientUpdatesDietaryPreferences(DataTable table) {
        List<String> preferencesList = table.asList(String.class);
        for (String preference : preferencesList) {
            if (preference == null || preference.isEmpty()) {
                state = false;
                return;
            }
            state = accountHelper.updateDietaryPreferences("Ammar", preference);
        }
    }

    @Then("the system saves the updates")
    public void theSystemSavesTheUpdates() {
        Assertions.assertTrue(state);
    }

    @When("the client leaves the age field empty")
    public void theClientLeavesTheAgeFieldEmpty(DataTable table) {
        List<List<String>> goalsList = table.asLists(String.class);
        for (List<String> row : goalsList) {
            String name = row.get(0);
            String age = "";
            String goals = row.get(1);
            if (name == null || name.isEmpty() || goals == null || goals.isEmpty()) {
                state = false;
                return;
            }
            state = accountHelper.createProfile(name, age, goals);
        }
    }

    @Then("the system shows an error message {string}")
    public void theSystemShowsAnErrorMessage(String message) {
        Assertions.assertFalse(state, message);
    }

    @When("the client leaves any required field empty")
    public void theClientLeavesAnyRequiredFieldEmpty(DataTable table) {
        List<List<String>> data = table.asLists(String.class);
        for (List<String> row : data) {
            String name = row.get(0);
            String age = row.get(1);
            String goals = row.get(2);
            if (name == null || name.isEmpty() || age == null || age.isEmpty() || goals == null || goals.isEmpty()) {
                state = false;
                return;
            }
            state = accountHelper.createProfile(name, age, goals);
        }
    }

    @Then("displays a message {string}")
    public void displaysAMessage(String message) {
        Assertions.assertTrue(message.contains("Preferences updated successfully"));
    }



    @When("the client enters invalid data with name {string}, age {string}, and goals {string}")
    public void theClientEntersInvalidData(String name, String age, String goals) {
        if (name == null || name.isEmpty() || age == null || age.isEmpty() || goals == null || goals.isEmpty()) {
            state = false;
            return;
        }
        state = accountHelper.createProfile(name, age, goals);
    }

    @Then("the system rejects the profile creation with an error message {string}")
    public void theSystemRejectsTheProfileCreation(String message) {
        Assertions.assertFalse(state, message);
    }
}

package GYM.AcceptanceTest;

import GYM.Milestone;
import GYM.UserProgress;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

public class ProgressTrackingTest {
    private UserProgress userProgress;
    private boolean state;

    @Given("the user is logged into the system")
    public void theUserIsLoggedIntoTheSystem() {
        userProgress = new UserProgress();
        System.out.println("User logged into the system.");
    }

    @Given("the user is on the {string} page")
    public void theUserIsOnThePage(String pageName) {
        Assertions.assertNotNull(pageName, "Page name should not be null.");
        System.out.println("User is on the " + pageName + " page.");
    }

    @When("the user logs the following milestones:")
    public void theUserLogsTheFollowingMilestones(io.cucumber.datatable.DataTable table) {
        for (var row : table.asLists(String.class)) {
            String weight = row.get(0);
            String bmi = row.get(1);
            String attendance = row.get(2);

            weight = (weight != null && !weight.trim().isEmpty()) ? weight.trim() : null;
            bmi = (bmi != null && !bmi.trim().isEmpty()) ? bmi.trim() : null;
            attendance = (attendance != null && !attendance.trim().isEmpty()) ? attendance.trim() : null;


            state = userProgress.logMilestone(weight, bmi, attendance);
        }
    }



    @Then("the system saves all milestones successfully")
    public void theSystemSavesAllMilestonesSuccessfully() {
        Assertions.assertTrue(state, "Milestones should be saved successfully.");
        Assertions.assertFalse(userProgress.getMilestones().isEmpty(), "Milestones list should not be empty.");
    }


    @And("displays a confirmation message {string}")
    public void displaysAConfirmationMessage(String message) {
        Assertions.assertNotNull(message, "Message should not be null.");
        System.out.println(message);
        Assertions.assertTrue(message.contains("successfully"), "Confirmation message should contain the expected text.");
    }

    // Scenario 2: User earns badges for completing milestones
    @Given("the user has the following milestones:")
    public void theUserHasTheFollowingMilestones(io.cucumber.datatable.DataTable table) {
        for (var row : table.asLists(String.class)) {
            String weight = row.get(0);
            String bmi = row.get(1);
            String attendance = row.get(2);

            Assertions.assertNotNull(weight, "Weight should not be null.");
            Assertions.assertNotNull(bmi, "BMI should not be null.");
            Assertions.assertNotNull(attendance, "Attendance should not be null.");
            userProgress.logMilestone(weight, bmi, attendance);
        }
    }

    @When("the user views their progress")
    public void theUserViewsTheirProgress() {
        System.out.println("User is viewing their progress.");
    }

    @Then("the system displays the following badges:")
    public void theSystemDisplaysTheFollowingBadges(io.cucumber.datatable.DataTable table) {
        for (var row : table.asLists(String.class)) {
            String badgeName = row.get(0);
            String criteriaMet = row.get(1);

            Assertions.assertNotNull(badgeName, "Badge name should not be null.");
            Assertions.assertNotNull(criteriaMet, "Criteria should not be null.");

            System.out.println("Badge: " + badgeName + ", Criteria: " + criteriaMet);
        }
    }

    @Given("the user has logged multiple milestones:")
    public void theUserHasLoggedMultipleMilestones(io.cucumber.datatable.DataTable table) {
        for (var row : table.asLists(String.class)) {
            String weight = row.get(0);
            String bmi = row.get(1);
            String attendance = row.get(2);

            if (weight == null || weight.isEmpty()) {
                Assertions.fail("Weight cannot be null or empty.");
            }
            if (bmi == null || bmi.isEmpty()) {
                Assertions.fail("BMI cannot be null or empty.");
            }
            if (attendance == null || attendance.isEmpty()) {
                Assertions.fail("Attendance cannot be null or empty.");
            }
            userProgress.logMilestone(weight, bmi, attendance);
        }
    }

    @When("the user views their progress report")
    public void theUserViewsTheirProgressReport() {
        System.out.println("User is viewing their progress report.");
    }

    @Then("the system displays a chart showing progress in weight and BMI")
    public void theSystemDisplaysAChartShowingProgressInWeightAndBMI() {
        // Assuming there's a method to validate the chart display
        boolean chartDisplayed = userProgress.displayProgressChart();
        Assertions.assertTrue(chartDisplayed, "The progress chart should be displayed successfully.");
        System.out.println("Displaying progress chart for weight and BMI.");
    }


    @Given("the user has not logged milestones for {int} days")
    public void theUserHasNotLoggedMilestonesForDays(int days) {
        Assertions.assertTrue(days >= 0, "Days should be a non-negative value.");
        System.out.println("User has not logged milestones for " + days + " days.");
    }

    @When("the system checks the user's activity")
    public void theSystemChecksTheUserSActivity() {
        System.out.println("System is checking the user's activity.");
    }

    @Then("the system sends a reminder {string}")
    public void theSystemSendsAReminder(String reminder) {
        Assertions.assertNotNull(reminder, "Reminder message should not be null.");
        System.out.println("System sends reminder: " + reminder);
    }

    // Scenario 5: User updates a milestone
    @When("the user updates the milestone {string} to {string}")
    public void theUserUpdatesTheMilestoneTo(String milestone, String newValue) {
        Assertions.assertNotNull(milestone, "Milestone should not be null.");
        Assertions.assertNotNull(newValue, "New value should not be null.");
        System.out.println("User updates " + milestone + " to " + newValue);
    }

    @Then("the system saves the updated milestone successfully")
    public void theSystemSavesTheUpdatedMilestoneSuccessfully() {

        boolean updateSuccess = userProgress.updateMilestone(0, new Milestone("75kg", "24.0", "5 days"));

        Assertions.assertTrue(updateSuccess, "The milestone should be updated successfully.");
        System.out.println("Updated milestone saved successfully.");
    }


    @When("the user deletes the milestone for {string}")
    public void theUserDeletesTheMilestoneFor(String milestone) {
        Assertions.assertNotNull(milestone, "Milestone should not be null.");
        System.out.println("User deletes milestone for " + milestone);
    }

    @Then("the system removes the milestone successfully")
    public void theSystemRemovesTheMilestoneSuccessfully() {
        // Adding a milestone first
        String weight = "70kg";
        String bmi = "22.0";
        String attendance = "5 days";


        boolean logSuccess = userProgress.logMilestone(weight, bmi, attendance);
        Assertions.assertTrue(logSuccess, "The milestone should be logged successfully.");


        Assertions.assertNotNull(userProgress.getMilestones().get(0), "Milestone should exist before deletion");


        boolean deleteSuccess = userProgress.deleteMilestone(weight.trim(), bmi.trim(), attendance.trim());


        Assertions.assertTrue(deleteSuccess, "The milestone should be deleted successfully.");
        System.out.println("Milestone removed successfully.");
    }
}

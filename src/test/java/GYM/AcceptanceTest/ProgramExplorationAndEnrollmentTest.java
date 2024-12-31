package GYM.AcceptanceTest;

import GYM.Client;
import GYM.Program;
import GYM.ProgramService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProgramExplorationAndEnrollmentTest {

    private final ProgramService programService = new ProgramService();
    private Program selectedProgram;
    private List<Program> filteredPrograms = new ArrayList<>();
    private final Client testClient = new Client("John Doe", "johndoe@example.com", "password123", "client", "basic");

    @Given("the client is on the program exploration page")
    public void theClientIsOnTheProgramExplorationPage() {

        System.out.println("Client is on the program exploration page.");
    }

    private void filterPrograms(List<String> filterCriteria, String filterType) {
        filteredPrograms.clear();
        for (String criterion : filterCriteria) {
            List<Program> result = (filterType.equals("difficulty")) ?
                    programService.filterProgramsByDifficulty(criterion) :
                    programService.filterProgramsByFocusArea(criterion);

            if (!result.isEmpty()) {
                filteredPrograms.addAll(result);
            }
        }
    }

    @When("the client filters programs by difficulty level")
    public void theClientFiltersProgramsByDifficultyLevel(List<String> difficultyLevels) {
        filterPrograms(difficultyLevels, "difficulty");
    }

    @Then("the system displays all programs with each difficulty level")
    public void theSystemDisplaysAllProgramsWithEachDifficultyLevel() {
        Assert.assertFalse("Filtered programs should not be empty for difficulty level", filteredPrograms.isEmpty());
    }

    @When("the client filters programs by focus area")
    public void theClientFiltersProgramsByFocusArea(List<String> focusAreas) {
        filterPrograms(focusAreas, "focus");
    }

    @Then("the system displays all programs in each focus area")
    public void theSystemDisplaysAllProgramsInEachFocusArea() {
        Assert.assertFalse("Filtered programs should not be empty for focus area", filteredPrograms.isEmpty());
    }

    @When("the client selects a program")
    public void theClientSelectsAProgram(List<String> programNames) {
        selectedProgram = null;
        for (String programName : programNames) {
            selectedProgram = programService.getProgramByName(programName);
            if (selectedProgram != null) {
                break;
            }
        }
        Assert.assertNotNull("Program selection failed. No program found", selectedProgram);
    }

    @Then("the system enrolls the client in the selected program")
    public void theSystemEnrollsTheClientInTheSelectedProgram() {
        Assert.assertNotNull("Selected program should not be null", selectedProgram);
        String message = programService.enrollClientInProgram(testClient, selectedProgram.getName());
        Assert.assertTrue("Client should be successfully enrolled", message.contains("successfully enrolled"));
    }

    @And("the system shows the confirmation message {string}")
    public void theSystemShowsTheConfirmationMessage(String message) {
        Assert.assertNotNull("Confirmation message should not be null", message);
        Assert.assertTrue("Confirmation message should contain program name", message.contains("{program name}"));
    }

    @Given("the client is enrolled in a program")
    public void theClientIsEnrolledInAProgram(List<String> programNames) {
        selectedProgram = null;
        for (String programName : programNames) {
            selectedProgram = programService.getProgramByName(programName);
            if (selectedProgram != null) {
                programService.enrollClientInProgram(testClient, selectedProgram.getName());
                break;
            }
        }
        Assert.assertNotNull("Client should be enrolled in a program", selectedProgram);
    }

    @When("the client requests to view the schedule of the program")
    public void theClientRequestsToViewTheScheduleOfTheProgram() {
        if (selectedProgram == null) {
            Assert.fail("No program selected for viewing schedule.");
        }
    }

    @Then("the system displays the schedule for the selected program")
    public void theSystemDisplaysTheScheduleForTheSelectedProgram() {
        if (selectedProgram != null) {
            String schedule = programService.getProgramSchedule(selectedProgram.getName());
            Assert.assertNotNull("Schedule should not be null", schedule);
        } else {
            Assert.fail("No program selected to display schedule.");
        }
    }
}

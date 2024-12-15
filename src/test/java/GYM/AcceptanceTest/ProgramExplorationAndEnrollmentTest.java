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

    private final ProgramService programService = new ProgramService(); // استخدام الخدمة
    private Program selectedProgram;
    private List<Program> filteredPrograms = new ArrayList<>();
    private final Client testClient = new Client("John Doe", "johndoe@example.com", "password123", "client", "basic"); // إنشاء عميل اختبار متكامل

    @Given("the client is on the program exploration page")
    public void theClientIsOnTheProgramExplorationPage() {
        System.out.println("Client is on the program exploration page");
    }

    @When("the client filters programs by difficulty level")
    public void theClientFiltersProgramsByDifficultyLevel(List<String> difficultyLevels) {
        filteredPrograms.clear();
        for (String difficultyLevel : difficultyLevels) {
            List<Program> result = programService.filterProgramsByDifficulty(difficultyLevel);
            if (result.isEmpty()) {
                System.out.println("No programs found with difficulty level: " + difficultyLevel);
            } else {
                filteredPrograms.addAll(result);
            }
        }
    }

    @Then("the system displays all programs with each difficulty level")
    public void theSystemDisplaysAllProgramsWithEachDifficultyLevel() {
        Assert.assertFalse("Filtered programs should not be empty for difficulty level", filteredPrograms.isEmpty());
        System.out.println("Filtered programs by difficulty level: " + filteredPrograms);
    }

    @When("the client filters programs by focus area")
    public void theClientFiltersProgramsByFocusArea(List<String> focusAreas) {
        filteredPrograms.clear();
        for (String focusArea : focusAreas) {
            List<Program> result = programService.filterProgramsByFocusArea(focusArea);
            if (result.isEmpty()) {
                System.out.println("No programs found with focus area: " + focusArea);
            } else {
                filteredPrograms.addAll(result);
            }
        }
    }

    @Then("the system displays all programs in each focus area")
    public void theSystemDisplaysAllProgramsInEachFocusArea() {
        Assert.assertFalse("Filtered programs should not be empty for focus area", filteredPrograms.isEmpty());
        System.out.println("Filtered programs by focus area: " + filteredPrograms);
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
        if (selectedProgram == null) {
            System.out.println("No program found with the given name(s): " + programNames);
        } else {
            System.out.println("Program selected: " + selectedProgram.getName());
        }
    }

    @Then("the system enrolls the client in the selected program")
    public void theSystemEnrollsTheClientInTheSelectedProgram() {
        Assert.assertNotNull("Selected program should not be null", selectedProgram);
        String message = programService.enrollClientInProgram(testClient, selectedProgram.getName());
        System.out.println(message);
        Assert.assertTrue("Client should be successfully enrolled", message.contains("successfully enrolled"));
    }

    @And("the system shows the confirmation message {string}")
    public void theSystemShowsTheConfirmationMessage(String message) {
        Assert.assertNotNull("Selected program should not be null", selectedProgram);
        Assert.assertTrue("Confirmation message should contain program name",
                message.contains("{program name}"));
        System.out.println("Confirmation message: " + message.replace("{program name}", selectedProgram.getName()));
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
        System.out.println("Client is enrolled in: " + selectedProgram.getName());
    }

    @When("the client requests to view the schedule of the program")
    public void theClientRequestsToViewTheScheduleOfTheProgram() {
        if (selectedProgram != null) {
            System.out.println("Client requests the schedule for: " + selectedProgram.getName());
        } else {
            System.out.println("No program selected for viewing schedule.");
        }
    }

    @Then("the system displays the schedule for the selected program")
    public void theSystemDisplaysTheScheduleForTheSelectedProgram() {
        if (selectedProgram != null) {
            String schedule = programService.getProgramSchedule(selectedProgram.getName());
            Assert.assertNotNull("Schedule should not be null", schedule);
            System.out.println(schedule);
        } else {
            System.out.println("No schedule to display for the selected program.");
        }
    }
}

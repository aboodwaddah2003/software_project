package GYM.AcceptanceTest;

import GYM.Program;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProgramExplorationAndEnrollmentTest {

    private Program selectedProgram;
    private List<Program> filteredPrograms = new ArrayList<>();
    private List<Program> allPrograms = List.of(
            new Program("Muscle Gain Program", "Advanced", "Muscle building"),
            new Program("Weight Loss Program", "Beginner", "Weight loss"),
            new Program("Flexibility Program", "Intermediate", "Flexibility")
    );

    @Given("the client is on the program exploration page")
    public void theClientIsOnTheProgramExplorationPage() {
        System.out.println("Client is on the program exploration page");
    }

    @When("the client filters programs by difficulty level")
    public void theClientFiltersProgramsByDifficultyLevel(List<String> difficultyLevels) {
        filteredPrograms.clear();
        for (String difficultyLevel : difficultyLevels) {
            boolean found = false;
            for (Program program : allPrograms) {
                if (program.getDifficultyLevel() != null && program.getDifficultyLevel().equalsIgnoreCase(difficultyLevel)) {
                    filteredPrograms.add(program);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No programs found with difficulty level: " + difficultyLevel);
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
            boolean found = false;
            for (Program program : allPrograms) {
                if (program.getFocusArea() != null && program.getFocusArea().equalsIgnoreCase(focusArea)) {
                    filteredPrograms.add(program);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No programs found with focus area: " + focusArea);
            } else {
                System.out.println("Programs found with focus area: " + focusArea + " : " + filteredPrograms);
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
        boolean found = false;
        for (String programName : programNames) {
            for (Program program : allPrograms) {
                if (program.getName().equalsIgnoreCase(programName)) {
                    selectedProgram = program;
                    found = true;
                    break;
                }
            }
        }
        // التأكد من أنه تم اختيار البرنامج بشكل صحيح
        if (!found) {
            System.out.println("No program found with the given name(s): " + programNames);
        } else {
            System.out.println("Program selected: " + selectedProgram.getName());
        }
    }


    @Then("the system enrolls the client in the selected program")
    public void theSystemEnrollsTheClientInTheSelectedProgram() {
        Assert.assertNotNull("Selected program should not be null", selectedProgram);
        System.out.println("Client enrolled in: " + selectedProgram.getName());
    }

    @And("the system shows the confirmation message {string}")
    public void theSystemShowsTheConfirmationMessage(String message) {
        Assert.assertTrue("Confirmation message should contain program name",
                message.contains("{program name}"));
        System.out.println("Confirmation message: " + message.replace("{program name}", selectedProgram.getName()));
    }

    @Given("the client is enrolled in a program")
    public void theClientIsEnrolledInAProgram(List<String> programNames) {
        boolean found = false;
        for (String programName : programNames) {
            for (Program program : allPrograms) {
                if (program.getName().equalsIgnoreCase(programName)) {
                    selectedProgram = program;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        Assert.assertNotNull("Client should be enrolled in a program", selectedProgram);
        if (selectedProgram != null) {
            System.out.println("Client is enrolled in: " + selectedProgram.getName());
        }
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
            System.out.println("Displaying schedule for: " + selectedProgram.getName());
        } else {
            System.out.println("No schedule to display for the selected program.");
        }
    }
}
